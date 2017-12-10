package dao.Interface;

import modelo.Cronograma;
import modelo.Projeto;

import java.util.List;

public interface CronogramaDao {

    public void salvar(Cronograma cronograma);

    public void alterar(String campo, String novo, String id);

    public List<Cronograma> buscar(String busca);

}
