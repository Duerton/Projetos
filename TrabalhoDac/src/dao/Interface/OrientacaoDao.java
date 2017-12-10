package dao.Interface;

import modelo.Aluno;
import modelo.Professor;

import java.util.List;

public interface OrientacaoDao {

    public void salvar(Aluno aluno, Professor professor);

    public void alterar(Aluno aluno, Professor professor, boolean resposta);

    public List<Aluno> listar(Professor professor);

}
