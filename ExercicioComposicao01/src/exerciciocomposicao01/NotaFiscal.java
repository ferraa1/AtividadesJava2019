package exerciciocomposicao01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "nota_fiscal")
public class NotaFiscal implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private int codigo;
    private String data;
    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_nota_fiscal")
    List<ItemNota> itens = new ArrayList<>();

    public void addItens(int quantidade, double desconto, Produto produto) {
        ItemNota item = new ItemNota(quantidade, desconto, produto, this);
        itens.add(item);
    }
    
    public NotaFiscal() {
    }

    public NotaFiscal(int codigo, String data, Cliente cliente) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
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

    public List<ItemNota> getItens() {
        return itens;
    }

    public void setItens(List<ItemNota> itens) {
        this.itens = itens;
    }
    
    @Override
    public String toString() {
        return "NotaFiscal{" + "id=" + id + ", codigo=" + codigo + ", data=" + data + ", cliente=" + cliente.getNome() + '}';
    }
    
}
