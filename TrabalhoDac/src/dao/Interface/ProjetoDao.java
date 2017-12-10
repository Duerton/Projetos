package dao.Interface;

import modelo.Projeto;

import java.util.List;

public interface ProjetoDao {

    public List<Projeto> listarDefesasAgendada();

    public List<Projeto> listarTodosProjetos();

    public Projeto salvar(Projeto projeto);

    public Projeto alterar(Projeto projeto);

    public List<Projeto> buscar(String busca);

}
