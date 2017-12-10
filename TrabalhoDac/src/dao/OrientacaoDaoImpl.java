package dao;

import dao.Interface.OrientacaoDao;
import dao.Util.JPAUtil;
import modelo.Orientacao;
import modelo.Professor;
import modelo.metamodelo.Orientacao_;
import modelo.metamodelo.Professor_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class OrientacaoDaoImpl implements OrientacaoDao {

    @PersistenceContext
    private EntityManager em = new JPAUtil().getEntityManager();

    @Override
    public void salvarPedidoOrientacao(Orientacao orientacao) {
        em.getTransaction().begin();
        em.persist(orientacao);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void aceitarPedidoOrientacao(Orientacao orientacao) {


        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Orientacao> update = cb.createCriteriaUpdate(Orientacao.class);
        update.from(Orientacao.class);
        update.set("aceito", orientacao.isAceito());

        try {
            em.createQuery(update).executeUpdate();
        } catch (Exception e) {

        }

        em.close();
    }

    @Override
    public List<Orientacao> listarOrientacoesPendentes(Professor professor){

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Orientacao> query = cb.createQuery(Orientacao.class);

        Root<Orientacao> root = query.from(Orientacao.class);
        Join<Orientacao,Professor> joinProfessor = root.join(Orientacao_.professor);

        Predicate predicate = cb.and(cb.equal(joinProfessor.get(Professor_.id),professor.getId()),
                cb.equal(root.get(Orientacao_.aceito),false));

        query.select(root).where(predicate);

        List<Orientacao> lista = null;
        try {
            lista = em.createQuery(query).getResultList();
        } catch(Exception e){

        }

        em.close();

        return lista;
    }
}
