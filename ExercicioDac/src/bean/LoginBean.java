package bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.PessoaDao;
import modelo.Pessoa;

public class LoginBean {

	private PessoaDao dao;
	
	public boolean efetuaLogin(Pessoa pessoa) {
		
		Pessoa pessoaEncontrada = this.dao.buscaPeloLogin(pessoa.getLogin());
		
		if(pessoaEncontrada!= null && possuiMesmaSenha(pessoaEncontrada,pessoa)) {
			return true;
		}
		return false;
	}
	
	/*public String efetuaLogout() {
		this.usuarioLogado.deslogar();
		return this.menu.paginaLogin();
	}

	
	private void limparForm() {
		this.pessoa = new Pessoa();
	}*/

	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	private boolean possuiMesmaSenha(Pessoa pessoaEncontrada, Pessoa pessoa) {
		return pessoaEncontrada.getSenha().equals(pessoa.getSenha());
	}
}
