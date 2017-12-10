package dao.Interface;

import modelo.Pessoa;

import java.util.List;

public interface PessoaDao {

    public Pessoa salvar(Pessoa pessoa);

    public Pessoa alterar(Pessoa pessoa);

    public List<Pessoa> listarUsuariosPendentes();
}
