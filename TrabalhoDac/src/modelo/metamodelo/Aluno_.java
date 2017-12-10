package modelo.metamodelo;


import modelo.Aluno;
import modelo.Pessoa_Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Aluno.class)
public class Aluno_ extends Pessoa_ {
    public static volatile SingularAttribute<Aluno,String> matricula;
    public static volatile SetAttribute<Aluno, Pessoa_Projeto> pessoa_projeto;

}
