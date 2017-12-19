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
    
    public Aluno buscaPorId(Integer id) {
    	TypedQuery<Aluno> query = em.createQuery("select a from Aluno a where a.id = :id", Aluno.class);
    	query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    public List<Aluno> listarTodosAlunos(){
        TypedQuery<Aluno> query = em.createQuery("select a from Aluno a", Aluno.class);
        List<Aluno> lista = query.getResultList();
        return lista;
    }
}
