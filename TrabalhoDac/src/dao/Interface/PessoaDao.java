package dao.Interface;

import modelo.Pessoa;

import java.util.List;

public interface PessoaDao<T> {

    public void salvar(T pessoa);

    public void alterar(String campo, String novo, String id);

    public List<Pessoa> buscar(String busca);

    public List<Pessoa> listarUsuariosPendentes();
}
