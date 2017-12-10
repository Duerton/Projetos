package modelo.metamodelo;


import modelo.Aluno;
import modelo.Orientacao;
import modelo.Professor;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Orientacao.class)
public class Orientacao_ {
    public static volatile SingularAttribute<Orientacao,Integer> id;
    public static volatile SingularAttribute<Orientacao,Professor> professor;
    public static volatile SingularAttribute<Orientacao,Aluno> aluno;
    public static volatile SingularAttribute<Orientacao,Boolean> aceito;
    public static volatile SingularAttribute<Orientacao,Date> registrado;
}
