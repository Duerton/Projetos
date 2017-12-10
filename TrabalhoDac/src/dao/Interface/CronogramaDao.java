package dao.Interface;

import modelo.Cronograma;
import modelo.Projeto;

import java.util.List;

public interface CronogramaDao {

    public Cronograma salvar(Cronograma cronograma);

    public Cronograma alterar(Cronograma cronograma);

    public List<Cronograma> buscar(Projeto projeto);

}
