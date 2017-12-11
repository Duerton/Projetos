package dao;

import javax.persistence.EntityManager;

import dao.Interface.PessoaDao;
import dao.Util.JPAUtil;
import modelo.Aluno;
import modelo.Pessoa;

import java.util.Date;
import java.util.List;

public class teste {

	private static PessoaDao<Aluno> alunoDao;

	public static void main(String [] args) {
		
		Aluno aluno = new Aluno();
		
		aluno.setEmail("duerton@gmail.com");
		aluno.setLogin("duerton");
		aluno.setNome("Duerton");
		aluno.setSenha("duerton");
		aluno.setRegistrado(new Date());
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();

		alunoDao = new PessoaDaoImpl<Aluno>(Aluno.class);
		System.out.println("000");
		List<Aluno> alunos;
		if (alunoDao != null) {
			//alunos = alunoDao.listarUsuariosPendentes();
			alunos = alunoDao.buscar("Duerton");
			System.out.println(alunos.get(0));
		} else {
			System.out.println("23242134");
		}
	}
}
