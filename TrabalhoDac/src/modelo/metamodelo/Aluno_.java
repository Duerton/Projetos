package modelo.metamodelo;


import modelo.Aluno;
import modelo.Aluno_Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Aluno.class)
public class Aluno_ extends Pessoa_ {
    public static volatile SingularAttribute<Aluno,String> matricula;
    public static volatile SetAttribute<Aluno, Aluno_Projeto> aluno_projeto;

}
