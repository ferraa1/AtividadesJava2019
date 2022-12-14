
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int codigo;
    private String titulo;
    private String sinopse;
    private int anoLancamento;
    private int duracao;
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Filme() {
    }

    public Filme(int codigo, String titulo, String sinopse, int anoLancamento, int duracao, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", sinopse=" + sinopse + ", anoLancamento=" + anoLancamento + ", duracao=" + duracao + ", genero=" + genero.toString() + '}';
    }

}
