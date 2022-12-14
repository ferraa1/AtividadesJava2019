package preparacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "venda")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String data;
    private boolean quitada;
    private double valor;
    @Column (name = "valor_pago")
    private double valorPago;
    @ManyToOne
    @Column (name = "id_cliente")
    private Cliente cliente;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_cliente")
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Venda() {
    }

    public Venda(String data, boolean quitada, double valor, double valorPago, Cliente cliente) {
        this.data = data;
        this.quitada = quitada;
        this.valor = valor;
        this.valorPago = valorPago;
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public boolean isQuitada() {
        return quitada;
    }

    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
    
    public void adicionarPagamentoDinheiro(double quantidadeEntrada, double valorPagamento) {
        Pagamento p = new Dinheiro(quantidadeEntrada, valorPagamento);
        pagamentos.add(p);
    }
    
    public void adicionarPagamentoCheque(String banco, int numero, double valorPagamento) {
        Pagamento p = new Cheque(banco, numero, valorPagamento);
        pagamentos.add(p);
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", quitada=" + quitada + ", valor=" + valor + ", valorPago=" + valorPago + ", cliente=" + cliente.toString() + '}';
    }
    
    
}
