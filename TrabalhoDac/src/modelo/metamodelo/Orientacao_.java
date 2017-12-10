package modelo.metamodelo;


import modelo.Aluno;
import modelo.Orientacao;
import modelo.Professor;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Orientacao.class)
public class Orientacao_ {
    public static volatile SingularAttribute<Orientacao,Integer> id;
    public static volatile SingularAttribute<Orientacao,Professor> professor;
    public static volatile SingularAttribute<Orientacao,Aluno> aluno;
    public static volatile SingularAttribute<Orientacao,Boolean> aceito;
}
