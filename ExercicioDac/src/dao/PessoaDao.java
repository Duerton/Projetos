package dao;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import modelo.Aluno;
import modelo.Professor;
import modelo.Projeto;

public class PessoaDao {

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

    
    public List<Projeto> buscar(String busca){
        em.getTransaction().begin();
        TypedQuery<Projeto> query = em.createQuery("select p from Pessoa p", Projeto.class);
        List<Projeto> lista = null;
        try {
            lista = query.getResultList();
        } catch(Exception e){

        }
        em.close();
        return lista;
    }
}
