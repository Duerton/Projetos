package dao.Interface;

import modelo.Projeto;

import java.util.List;

public interface ProjetoDao {

    public List<Projeto> listarDefesasAgendada();

    public List<Projeto> listarTodosProjetos();

    public void salvar(Projeto projeto);

    public void alterar(String campo, String novo, String id);

    public List<Projeto> buscar(String busca);

}
