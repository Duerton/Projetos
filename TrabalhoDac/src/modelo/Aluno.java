package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "A")
public class Aluno extends Pessoa{
	
	@Column(name="matricula")
	private long matricula;
	
	@OneToMany(mappedBy="aluno")
	private List<Aluno_Projeto> aluno_Projeto;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno{" +
				"matricula=" + matricula +
				", aluno_Projeto=" + aluno_Projeto +
				'}';
	}
}
