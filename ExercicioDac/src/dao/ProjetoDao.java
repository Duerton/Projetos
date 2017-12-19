package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import modelo.Pessoa;
import modelo.Projeto;

public class ProjetoDao {
	
	@PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();
	
    /*public List<Projeto> listarDefesasAgendada(){

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
    }*/

    
    public List<Projeto> listarTodosProjetos() {
    	TypedQuery<Projeto> query = em.createQuery("select p from Projeto p", Projeto.class);
        List<Projeto> lista = query.getResultList();
        return lista;
    }

    
    public void salvar(Projeto projeto) {
        em.getTransaction().begin();
        em.persist(projeto);
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
}
