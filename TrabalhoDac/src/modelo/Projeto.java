package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@JoinColumn(name="idProfessor")
	private Professor professor;
	
	@OneToMany(mappedBy="projeto")
	private List<Aluno_Projeto> Projetopessoa;
	
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

	@Column(name="registrado")
	private Date registrado;

	public int getId() {
		return idProjeto;
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

	public Date getRegistrado() {
		return registrado;
	}

	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}

	@Override
	public String toString() {
		return "Projeto{" +
				"idProjeto=" + idProjeto +
				", professor=" + professor +
				", Projetopessoa=" + Projetopessoa +
				", cronograma=" + cronograma +
				", nota=" + nota +
				", titulo='" + titulo + '\'' +
				", resumo='" + resumo + '\'' +
				", bibliografia='" + bibliografia + '\'' +
				", registrado=" + registrado +
				'}';
	}
}
