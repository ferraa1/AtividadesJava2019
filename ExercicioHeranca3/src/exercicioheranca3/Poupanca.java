package exercicioheranca3;

public class Poupanca extends Conta {
    
    private int variacao;

    public Poupanca() {
    }

    public Poupanca(int variacao, int numero, double saldo) {
        super(numero, saldo);
        this.variacao = variacao;
    }

    public int getVariacao() {
        return variacao;
    }

    public void setVariacao(int variacao) {
        this.variacao = variacao;
    }

    @Override
    public String toString() {
        return "Poupanca{" + "variacao=" + variacao + '}';
    }
    
    @Override
    public double getSaldoDisponivel() {
        if (variacao == 1) {
            return super.getSaldo() * 0.05;
        } else if (variacao == 2) {
            return super.getSaldo() * 0.07;
        } else {
            return super.getSaldo() * 0.09;
        }
    }
    
}
