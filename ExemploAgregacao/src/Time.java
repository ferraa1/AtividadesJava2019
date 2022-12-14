
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "times")
public class Time implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<Atleta> atletas = new ArrayList<>();
    
    
    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
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

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

    @Override
    public String toString() {
        return "Time{" + "id=" + id + ", nome=" + nome + '}';
    }

    public void addAtleta (Atleta a) {
        atletas.add(a);
    }
}
