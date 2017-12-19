package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.AlunoDao;
import dao.ProfessorDao;
import dao.ProjetoDao;
import modelo.Aluno;
import modelo.Professor;
import modelo.Projeto;

@ManagedBean
@ViewScoped
public class ProjetoBean {

	
	private Projeto projeto = new Projeto();
	private ProjetoDao daoProjeto = new ProjetoDao();
	private ProfessorDao daoProfessor = new ProfessorDao();
	private AlunoDao daoAluno = new AlunoDao();
	private Integer idProfessor;
	private Integer idAluno;
	private List<Aluno> listaAluno = new ArrayList<Aluno>();
	
	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}	
	
	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public void adicionarProfessor() {
		Professor professor = daoProfessor.buscaPorId(idProfessor);
		this.projeto.setProfessor(professor);
	}
	
	public void adicionarAluno() {
		Aluno aluno = daoAluno.buscaPorId(idAluno);
		listaAluno.add(aluno);
		this.projeto.setListaAluno(listaAluno);
	}

	public Projeto getProjeto() {
		return this.projeto;
	}
	
	public List<Projeto> getProjetos(){
		return daoProjeto.listarTodosProjetos();
	}

	public void gravar() {
		daoProjeto.salvar(projeto);;
	}
}
