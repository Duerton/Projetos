package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.DAO;
import modelo.Aluno;

@ManagedBean
public class AlunoBean {

	private Aluno aluno = new Aluno();
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public List<Aluno> getAlunos() {
		return new DAO<Aluno>(Aluno.class).listaTodos();
	}
	
	public void gravar() {
		new DAO<Aluno>(Aluno.class).adiciona(this.aluno);
	}
	
}
