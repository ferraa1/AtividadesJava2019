package preparacao;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "d")
public class Dinheiro extends Pagamento {
    
    @Column (name = "quantidade_entrada")
    private double quantidadeEntrada;

    public Dinheiro() {
    }

    public Dinheiro(double quantidadeEntrada, double valorPagamento) {
        super(valorPagamento);
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public double getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(double quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    @Override
    public String toString() {
        return super.toString() + " Dinheiro{" + "quantidadeEntrada=" + quantidadeEntrada + '}';
    }
    
    
}
