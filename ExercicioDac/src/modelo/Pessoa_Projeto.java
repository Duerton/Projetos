package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pessoa_Projeto")
public class Pessoa_Projeto {
	
	@Id
	@Column(name="id_ProjetoAluno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProjetoAluno;
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="idProjeto")
	private Projeto projeto;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
}
