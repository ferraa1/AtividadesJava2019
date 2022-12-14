package exercicioheranca3;

public class Corrente extends Conta {
    
    private double limite;

    public Corrente() {
    }

    public Corrente(double limite, int numero, double saldo) {
        super(numero, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Corrente{" + "limite=" + limite + '}';
    }
    
    @Override
    public double getSaldoDisponivel() {
        return super.getSaldo() + limite;
    }
    
}
