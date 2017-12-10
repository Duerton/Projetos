package dao.Interface;

import modelo.Orientacao;
import modelo.Professor;

import java.util.List;

public interface OrientacaoDao {

    public void salvarPedidoOrientacao(Orientacao orientacao);

    public void aceitarPedidoOrientacao(Orientacao orientacao);

    public List<Orientacao> listarOrientacoesPendentes(Professor professor);

}
