package modelo.metamodelo;

import modelo.Professor;
import modelo.Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Professor.class)
public class Professor_ extends Pessoa_ {
    public static volatile SingularAttribute<Professor,String> titulacao;
    public static volatile SetAttribute<Professor, Projeto> projeto;
}
