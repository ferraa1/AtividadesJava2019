package exercicioheranca1;

public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private float faturamentomes;
    private int categoria;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, float faturamentomes, int categoria, String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.faturamentomes = faturamentomes;
        this.categoria = categoria;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getFaturamentomes() {
        return faturamentomes;
    }

    public void setFaturamentomes(float faturamentomes) {
        this.faturamentomes = faturamentomes;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + "PessoaJuridica{" + "cnpj=" + cnpj + ", faturamentos=" + faturamentomes + ", categoria=" + categoria;
    }

    @Override
    public float getImpostoDevido() {
        float imposto = faturamentomes;
        if (categoria == 1) {
            imposto *= 0.02;
        } else if (categoria == 2) {
            imposto *= 0.05;
        } else {
            imposto *= 0.15;
        }
        return imposto;
    }
}
