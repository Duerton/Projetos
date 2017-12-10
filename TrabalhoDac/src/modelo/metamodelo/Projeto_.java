package modelo.metamodelo;

import modelo.Cronograma;
import modelo.Aluno_Projeto;
import modelo.Professor;
import modelo.Projeto;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Projeto.class)
public class Projeto_ {
    public static volatile SingularAttribute<Projeto,Integer> id;
    public static volatile SingularAttribute<Projeto,Professor> professor;
    public static volatile SetAttribute<Projeto, Aluno_Projeto> aluno_projeto;
    public static volatile SingularAttribute<Projeto, Cronograma> cronograma;
    public static volatile SingularAttribute<Projeto,Float> nota;
    public static volatile SingularAttribute<Projeto,String> titulo;
    public static volatile SingularAttribute<Projeto,String> resumo;
    public static volatile SingularAttribute<Projeto,String> bibliografia;
    public static volatile SingularAttribute<Projeto,Date> registrado;
}
