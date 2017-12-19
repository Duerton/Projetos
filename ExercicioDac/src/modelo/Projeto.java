package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Projeto")
public class Projeto {
	
	@Id
	@Column(name="id_projeto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProjeto;
	
	@OneToOne
	@JoinColumn(name="idPessoa")
	private Professor professor;
	
	@ManyToMany
	@JoinColumn(name="idPessoa")
	private List<Aluno> aluno;
	
	@OneToOne
	@JoinColumn(name="idCronograma")
	private Cronograma cronograma;
	
	@Column(name="nota")
	private float nota;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="resumo")
	private String resumo;
	
	@Column(name="bibliografia")
	private String bibliografia;

	public int getId() {
		return idProjeto;
	}

	public void setId(int id) {
		this.idProjeto = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setListaAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}
	
	
	
}
