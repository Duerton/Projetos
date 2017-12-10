package modelo.metamodelo;

import modelo.Aluno;
import modelo.Aluno_Projeto;
import modelo.Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Aluno_Projeto.class)
public class Aluno_Projeto_ {
    public static volatile SingularAttribute<Aluno_Projeto,Integer> id;
    public static volatile SetAttribute<Aluno_Projeto, Aluno> alunos;
    public static volatile SingularAttribute<Aluno_Projeto, Projeto> projeto;
}
