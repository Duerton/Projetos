package bean.Interface;

import modelo.Projeto;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface ProjetoBean {

    public void editarProjeto(Projeto projeto);

    public boolean alterarDatasParciais(Date date);

    public List<Projeto> listarDefesasAgendadas();

    public boolean enviarArquivo(File file);

    public List<Projeto> listarTodosProjetos();

    public List<Projeto> buscarProjeto(String busca);



}
