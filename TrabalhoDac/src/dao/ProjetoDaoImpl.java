package dao;

import dao.Interface.ProjetoDao;
import dao.Util.JPAUtil;
import modelo.*;
import modelo.metamodelo.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class ProjetoDaoImpl implements ProjetoDao {

    @PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();

    @Override
    public List<Projeto> listarDefesasAgendada(){

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Projeto> query = cb.createQuery(Projeto.class);
        Root<Projeto> root = query.from(Projeto.class);

        query.select(root).where(cb.isNull(root.get(Projeto_.cronograma)));

        List<Projeto> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }
        em.close();

        return lista;
    }

    @Override
    public List<Projeto> listarTodosProjetos() {

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Projeto> query = cb.createQuery(Projeto.class);
        Root<Projeto> root = query.from(Projeto.class);

        query.select(root);

        List<Projeto> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }
        em.close();

        return lista;
    }

    @Override
    public void salvar(Projeto projeto) {
        em.getTransaction().begin();
        em.persist(projeto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void alterar(String campo, String novo, String id) {

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Projeto> update = cb.createCriteriaUpdate(Projeto.class);
        update.from(Projeto.class);
        update.set(campo, novo);

        try {
            em.createQuery(update).executeUpdate();
        } catch (Exception e) {

        }

        em.close();
    }

    @Override
    public List<Projeto> buscar(String busca){

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Projeto> query = cb.createQuery(Projeto.class);

        Root<Projeto> root = query.from(Projeto.class);
        Join<Projeto, Professor> joinProfessor = root.join(Projeto_.professor);
        SetJoin<Projeto, Pessoa_Projeto> joinAlunoProjeto = root.join(Projeto_.pessoa_projeto);

        Root<Aluno> root2 = query.from(Aluno.class);
        SetJoin<Aluno, Pessoa_Projeto> joinProjetoAluno = root2.join(Aluno_.pessoa_projeto);

        Root<Pessoa_Projeto> root3 = query.from(Pessoa_Projeto.class);
        SetJoin<Pessoa_Projeto, Aluno> joinAluno = root3.join(Pessoa_Projeto_.alunos);

        Predicate predicate =cb.or((cb.equal(root.get(Projeto_.titulo),busca)),
                (cb.equal(joinProfessor.get(Professor_.nome),busca)),
                (cb.equal(joinAlunoProjeto.get(Pessoa_Projeto_.alunos),joinProjetoAluno.get(Pessoa_Projeto_.alunos))),
                (cb.equal(joinAluno.get(Aluno_.nome),busca)));

        query.multiselect(root,root2,root3).where(predicate);

        List<Projeto> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }

        em.close();

        return lista;

    }
}
