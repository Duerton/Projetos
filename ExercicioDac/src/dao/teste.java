package dao;

import java.util.List;

import bean.AlunoBean;
import bean.ProfessorBean;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;
import modelo.Projeto;

public class teste {

	
	public static void main(String [] args) {
		
		ProjetoDao projetoDao = new ProjetoDao();
		PessoaDao pessoaDao = new PessoaDao();
		AlunoBean alunoBean = new AlunoBean();
		ProfessorBean professorBean = new ProfessorBean();
		
		Aluno aluno = new Aluno();
		
		aluno.setEmail("duerton@gmail.com");
		aluno.setLogin("duerton");
		aluno.setNome("Duerton");
		aluno.setSenha("duerton");
		
		Professor professor = new Professor();
		professor.setEmail("professor@professor.com");
		professor.setLogin("professor");
		professor.setNome("Geraldo");
		professor.setSenha("professor");
		professor.setTitulacao("Doutor");
		
		Projeto projeto = new Projeto();
		projeto.setBibliografia("Livro bom");
		projeto.setResumo("resumo do livro bom");
		projeto.setTitulo("TCC");
		projeto.setProfessor(professor);
		
//		pessoaDao.salvar(professor);
		projetoDao.salvar(projeto);
		
		
		
		
//		for (Pessoa pessoa : lista) {
//			System.out.println(pessoa.getNome());
//		}
	}
}
