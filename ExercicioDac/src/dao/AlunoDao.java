package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;

import modelo.Aluno;
import modelo.Projeto;

public class AlunoDao {
	
	@PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();
	    
    public void salvar(Aluno aluno) {
        
        em.persist(aluno);
    }

    
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
    
    public List<Aluno> listarTodosAlunos(){
        TypedQuery<Aluno> query = em.createQuery("select a from Aluno a", Aluno.class);
        List<Aluno> lista = query.getResultList();
        return lista;
    }
}
