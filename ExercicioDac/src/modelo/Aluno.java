package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "A")
public class Aluno extends Pessoa{
	
	@Column(name="matricula")
	private long matricula;
	
	@ManyToMany(mappedBy="aluno")
	private List<Projeto> projeto;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
}
