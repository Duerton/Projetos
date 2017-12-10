package modelo.metamodelo;

import modelo.Aluno;
import modelo.Pessoa_Projeto;
import modelo.Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pessoa_Projeto.class)
public class Pessoa_Projeto_ {
    public static volatile SingularAttribute<Pessoa_Projeto,Integer> id;
    public static volatile SetAttribute<Pessoa_Projeto, Aluno> alunos;
    public static volatile SingularAttribute<Pessoa_Projeto, Projeto> projeto;
}
