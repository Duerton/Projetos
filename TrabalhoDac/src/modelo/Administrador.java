package modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "D")
public class Administrador extends Pessoa{
	
}
