package exerciciocomposicao01;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "item_nota")
public class ItemNota implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private int quantidade;
    private double desconto;
    @ManyToOne
    @JoinColumn (name = "id_produto")
    private Produto produto;
    @ManyToOne
    @JoinColumn (name = "id_nota_fiscal")
    private NotaFiscal notaFiscal;

    public ItemNota() {
    }

    public ItemNota(int quantidade, double desconto, Produto produto, NotaFiscal notaFiscal) {
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.produto = produto;
        this.notaFiscal = notaFiscal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public String toString() {
        return "ItemNota{" + "id=" + id + ", quantidade=" + quantidade + ", desconto=" + desconto + ", produto=" + produto.getCodigo() + ", notaFiscal=" + notaFiscal.getCodigo() + '}';
    }
    
}
