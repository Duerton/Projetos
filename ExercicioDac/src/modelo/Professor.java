package modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "P")
public class Professor extends Pessoa{

	@Column(name="titulacao")
	private String titulacao;
	
	@OneToOne(mappedBy="professor")
	private Projeto projeto;

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	
}
