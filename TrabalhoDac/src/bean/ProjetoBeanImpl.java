package bean;

import bean.Interface.ProjetoBean;
import modelo.Projeto;

import java.io.File;
import java.util.Date;
import java.util.List;

public class ProjetoBeanImpl implements ProjetoBean {

    @Override
    public void editarProjeto(Projeto projeto) {

    }

    @Override
    public boolean alterarDatasParciais(Date date) {
        return false;
    }

    @Override
    public List<Projeto> listarDefesasAgendadas() {
        return null;
    }

    @Override
    public boolean enviarArquivo(File file) {
        return false;
    }

    @Override
    public List<Projeto> listarTodosProjetos() {
        return null;
    }

    @Override
    public List<Projeto> buscarProjeto(String busca) {
        return null;
    }
}
