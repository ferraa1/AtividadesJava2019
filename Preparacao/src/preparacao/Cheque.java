package preparacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "c")
public class Cheque extends Pagamento {
    
    private String banco;
    private int numero;

    public Cheque() {
    }

    public Cheque(String banco, int numero, double valorPagamento) {
        super(valorPagamento);
        this.banco = banco;
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + " Cheque{" + "banco=" + banco + ", numero=" + numero + '}';
    }
    
    
}
