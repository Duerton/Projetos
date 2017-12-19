package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ProjetoDao;
import modelo.Projeto;

@ManagedBean
public class ProjetoBean {

	
	private Projeto projeto = new Projeto();
	private ProjetoDao dao = new ProjetoDao();
	
	public Projeto getProjeto() {
		return this.projeto;
	}
	
	public List<Projeto> getProjetos(){
		return dao.listarTodosProjetos();
	}

	public void gravar() {
		dao.salvar(projeto);;
	}
}
