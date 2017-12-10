package bean.Interface;

import modelo.Aluno;
import modelo.Professor;
import modelo.Projeto;

import java.util.List;

public interface ProfessorBean {

    public void inserirNota(Projeto projeto, int nota);

    public List<Aluno> listarPedidos();

    public void aceitarBanca();

    public void SolicitarBanca(Projeto projeto, Professor professor1, Professor professor2);

    public void aceitarOrientacao(Boolean resposta);

}
