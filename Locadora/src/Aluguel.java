
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "aluguel")
public class Aluguel implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private int codigo;
    private String data;
    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn (name = "id_filme")
    private Filme filme;

    public Aluguel() {
    }

    public Aluguel(int codigo, String data, Cliente cliente, Filme filme) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.filme = filme;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Aluguel{" + "id=" + id + ", codigo=" + codigo + ", data=" + data + ", cliente=" + cliente.toString() + ", filme=" + filme.toString() + '}';
    }
    
    public int calcularIdade() {
        return Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(cliente.getDataNascimento().substring(6));
    }
    
    public boolean verificaAluguel() {
        return filme.getGenero().getClassificacao() <= calcularIdade();
    }
    
    public String calcularDataDevolucao() {
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6));
        Calendar c = new GregorianCalendar(ano, (mes - 1), dia);
        c.add(Calendar.DAY_OF_MONTH, 5);
        return c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR);
    }
}
