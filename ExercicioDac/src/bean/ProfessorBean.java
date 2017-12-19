package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.PessoaDao;
import modelo.Professor;

@ManagedBean
public class ProfessorBean {

	private Professor professor = new Professor();
	private PessoaDao dao = new PessoaDao();
	
	public Professor getProfessor() {
		return professor;
	}
	
	public List<Professor> getProfessores() {
		return dao.listarTodosProfessores();
	}
	
	public void gravar(Professor professor) {
		dao.salvar(professor);;
	}
}
