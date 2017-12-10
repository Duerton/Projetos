package dao;

import dao.Interface.CronogramaDao;
import dao.Util.JPAUtil;
import modelo.*;
import modelo.metamodelo.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class CronogramaDaoImpl implements CronogramaDao {

    @PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();

    @Override
    public void salvar(Cronograma cronograma) {
        em.getTransaction().begin();
        em.persist(cronograma);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void alterar(String campo, String novo, String id){

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Cronograma> update = cb.createCriteriaUpdate(Cronograma.class);
        update.from(Cronograma.class);
        update.set(campo,novo);

        try{
            em.createQuery(update).executeUpdate();
        } catch(Exception e){

        }

        em.close();
    }

    @Override
    public List<Cronograma> buscar(String busca) {

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cronograma> query = cb.createQuery(Cronograma.class);

        Root<Cronograma> root = query.from(Cronograma.class);
        Join<Cronograma, Projeto> joinProjeto = root.join(Cronograma_.projeto);

        Root<Projeto> root1 = query.from(Projeto.class);
        Join<Projeto, Professor> joinProfessor = root1.join(Projeto_.professor);
        SetJoin<Projeto, Aluno_Projeto> joinAlunoProjeto = root1.join(Projeto_.aluno_projeto);

        Root<Aluno> root2 = query.from(Aluno.class);
        SetJoin<Aluno, Aluno_Projeto> joinProjetoAluno = root2.join(Aluno_.aluno_projeto);

        Root<Aluno_Projeto> root3 = query.from(Aluno_Projeto.class);
        SetJoin<Aluno_Projeto, Aluno> joinAluno = root3.join(Aluno_Projeto_.alunos);

        Predicate or =cb.or((cb.equal(joinProjeto.get(Projeto_.titulo),busca)),
               (cb.equal(joinProfessor.get(Professor_.nome),busca)),
                (cb.equal(joinAlunoProjeto.get(Aluno_Projeto_.alunos),joinProjetoAluno.get(Aluno_Projeto_.alunos))),
                (cb.equal(joinAluno.get(Aluno_.nome),busca)));

        query.multiselect(root,root1,root2,root3).where(or);
        List<Cronograma> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }

        em.close();

        return lista;
    }
}
