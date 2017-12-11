package dao;

import dao.Interface.PessoaDao;
import dao.Util.JPAUtil;
import modelo.Pessoa;
import modelo.metamodelo.Pessoa_;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class PessoaDaoImpl<T> implements PessoaDao{

    @PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();

    private final Class<T> classe;

    public PessoaDaoImpl(Class<T> classe) {
        this.classe = classe;
    }

    @Override
    public void salvar(Object pessoa){
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
    }

    @Override
    public void alterar(String campo, String novo, String id) {

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<T> update = cb.createCriteriaUpdate(classe);
        update.from(classe);
        update.set(campo,novo);

        try{
            em.createQuery(update).executeUpdate();
        } catch(Exception e){

        }

        em.close();
    }

    @Override
    public List<T> buscar(String busca) {

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(classe);
        Root<T> root = query.from(classe);

        query.select(root).where(cb.equal(root.get("nome"),busca));

        List<T> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }

        em.close();

        return lista;
    }

    @Override
    public List<T> listarUsuariosPendentes() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(classe);
        Root<T> root = query.from(classe);

        Predicate predicate = cb.equal(root.get("ativo"),false);
        query.select(root).where(predicate);

        List<T> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }
        em.close();

        return lista;
    }
}
