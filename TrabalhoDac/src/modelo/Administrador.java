package modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "D")
public class Administrador extends Pessoa{

    @Column(name="autorizacao")
    private boolean autorizacao;

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador{" +
                "autorizacao=" + autorizacao +
                '}';
    }
}
