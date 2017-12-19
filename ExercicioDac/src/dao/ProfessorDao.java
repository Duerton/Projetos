package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;

import modelo.Professor;
import modelo.Projeto;

public class ProfessorDao {

	@PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();
	    
    public void salvar(Professor professor) {
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
        em.close();
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
    
    public List<Professor> listarTodosProfessores(){
        TypedQuery<Professor> query = em.createQuery("select p from Professor p", Professor.class);
        List<Professor> lista = query.getResultList();
        return lista;
    }
}
