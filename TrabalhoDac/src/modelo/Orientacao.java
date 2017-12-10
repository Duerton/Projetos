package modelo;


import javax.persistence.*;

@Entity
@Table(name="Orientacao")
public class Orientacao {

    @Id
    @Column(name="id_orientacao")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_orientacao;

    @ManyToOne
    @JoinColumn(name="idProfessor")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="idAluno")
    private Aluno aluno;

    @Column(name="aceito")
    private boolean aceito;

    public Integer getId_orientacao() {
        return id_orientacao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }
}
