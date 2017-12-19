package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;

import modelo.Aluno;
import modelo.Pessoa;
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
    
    public void salvar(Pessoa pessoa) {
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        
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

    
    public List<Pessoa> listarTodasPessoas(){
        TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
        List<Pessoa> lista = query.getResultList();
        return lista;
        
    }
    
    public List<Aluno> listarTodosAlunos(){
        TypedQuery<Aluno> query = em.createQuery("select a from Aluno a", Aluno.class);
        List<Aluno> lista = query.getResultList();
        return lista;
    }
    
    public List<Professor> listarTodosProfessores(){
        TypedQuery<Professor> query = em.createQuery("select p from Professor p", Professor.class);
        List<Professor> lista = query.getResultList();
        return lista;
    }
    
    public Pessoa buscaPeloLogin(String login) {
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p where p.login = :login", Pessoa.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}
