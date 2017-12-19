package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.PessoaDao;
import modelo.Pessoa;

@ManagedBean
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private PessoaDao dao = new PessoaDao();

	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return dao.listarTodasPessoas();
	}

	public void gravar() {
		dao.salvar(pessoa);
	}
	
	public String efetuaLogin() {
		
		Pessoa usuarioEncontrado = dao.buscaPeloLogin(pessoa.getLogin());
		if(pessoa.getSenha() != null && usuarioEncontrado.getSenha().equals(pessoa.getSenha())) {
			return "cadastro?faces-redirect=true";
		}
		criaMensagem("Usuário não encontrado!");
		return "";
	}
	
	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}
	
	public void efetuaLogout() {
		
	}
}
