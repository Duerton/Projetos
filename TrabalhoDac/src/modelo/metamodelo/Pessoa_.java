package modelo.metamodelo;

import modelo.Pessoa;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pessoa.class)
public class Pessoa_ {
    public static volatile SingularAttribute<Pessoa,Integer> id;
    public static volatile SingularAttribute<Pessoa,String> nome;
    public static volatile SingularAttribute<Pessoa,String> email;
    public static volatile SingularAttribute<Pessoa,String> login;
    public static volatile SingularAttribute<Pessoa,String> senha;
    public static volatile SingularAttribute<Pessoa,Boolean> ativo;
}
