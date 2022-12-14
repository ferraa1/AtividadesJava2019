package exercicioheranca3;

public class Banco {
    
    private int numero;
    private String endereco;

    public Banco() {
    }

    public Banco(int numero, String endereco) {
        this.numero = numero;
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Banco{" + "numero=" + numero + ", endereco=" + endereco + '}';
    }
    
}
