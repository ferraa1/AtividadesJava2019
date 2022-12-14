package exercicioheranca3;

public abstract class Conta {
    
    private int numero;
    private double saldo;

    public Conta() {
    }

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", saldo=" + saldo + '}';
    }
    
    public abstract double getSaldoDisponivel();
    
    public void sacar (double valor) {
        
    }
    
    public void depositar(double valor) {
        
    }
    
}
