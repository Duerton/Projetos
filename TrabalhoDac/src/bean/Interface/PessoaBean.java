package bean.Interface;

import modelo.Pessoa;

public interface PessoaBean {

    public void cadastrar(Pessoa pessoa);

    public void editarCadastro(String nome, String email, String login, String senha);

}
