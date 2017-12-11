package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.DAO;
import modelo.Professor;

@ManagedBean
public class ProfessorBean {

	private Professor professor = new Professor();
	
	public Professor getProfessor() {
		return professor;
	}
	
	public List<Professor> getProfessores() {
		return new DAO<Professor>(Professor.class).listaTodos();
	}
	
	public void gravar() {
		new DAO<Professor>(Professor.class).adiciona(this.professor);
	}
}
