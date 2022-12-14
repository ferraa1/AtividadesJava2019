
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "genero")
public class Genero implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private int classificacao;

    public Genero() {
    }

    public Genero(String nome, int classificacao) {
        this.nome = nome;
        this.classificacao = classificacao;
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

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nome=" + nome + ", classificacao=" + classificacao + '}';
    }
    
}
