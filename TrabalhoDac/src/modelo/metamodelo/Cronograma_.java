package modelo.metamodelo;


import modelo.Cronograma;
import modelo.Projeto;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Cronograma.class)
public class Cronograma_ {
    public static volatile SingularAttribute<Cronograma,Integer> id;
    public static volatile SingularAttribute<Cronograma,Date> dataDefesa;
    public static volatile SingularAttribute<Cronograma,Projeto> projeto;
    public static volatile SingularAttribute<Cronograma,Date> registrado;

}
