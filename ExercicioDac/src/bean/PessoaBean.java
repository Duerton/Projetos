package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.DAO;
import modelo.Pessoa;

@ManagedBean
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private char tipo;
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return new DAO<Pessoa>(Pessoa.class).listaTodos();
	}

	public void gravar() {
		System.out.println("Gravando pessoa " + this.pessoa.getNome());
				
		new DAO<Pessoa>(Pessoa.class).adiciona(this.pessoa);
	}
}
