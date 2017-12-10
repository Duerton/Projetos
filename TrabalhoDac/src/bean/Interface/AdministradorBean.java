package bean.Interface;

import modelo.Pessoa;

import java.util.List;

public interface AdministradorBean {

    public List<Pessoa> listarUsuariosPendentes();

    public List<Pessoa> incluirListaProfessores();

    public void solicitarInclusaoNotas();

    public void aceitarUsuario();

}
