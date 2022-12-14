
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atletas")
public class Atleta implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;

    public Atleta() {
    }

    public Atleta(String nome, int idade, Time time) {
        this.nome = nome;
        this.idade = idade;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Atleta{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
    }

}
