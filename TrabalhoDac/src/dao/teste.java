package dao;

import javax.persistence.EntityManager;

import dao.Util.JPAUtil;
import modelo.Aluno;

public class teste {

	
	public static void main(String [] args) {
		
		Aluno aluno = new Aluno();
		
		aluno.setEmail("duerton@gmail.com");
		aluno.setLogin("duerton");
		aluno.setNome("Duerton");
		aluno.setSenha("duerton");
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}
}
