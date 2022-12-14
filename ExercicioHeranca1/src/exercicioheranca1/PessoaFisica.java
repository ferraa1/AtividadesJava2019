package exercicioheranca1;

public class PessoaFisica extends Pessoa {

    private String cpf;
    private String rg;
    private float salario;
    private int qtdeDependentes;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String rg, float salario, int qtdeDependentes, String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.qtdeDependentes = qtdeDependentes;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getQtdeDependentes() {
        return qtdeDependentes;
    }

    public void setQtdeDependentes(int qtdeDependentes) {
        this.qtdeDependentes = qtdeDependentes;
    }

    @Override
    public String toString() {
        return super.toString() + " PessoaFisica{" + "cpf=" + cpf + ", rg=" + rg + ", salario=" + salario + ", qtdeDependentes=" + qtdeDependentes;
    }

    @Override
    public float getImpostoDevido() {
        float imposto = salario;
        if (salario <= 500) {
            imposto *= 0;
        } else if (salario <= 1000) {
            imposto = (float) (salario * (salario * 0.05 - (50 * qtdeDependentes)));
        } else {
            imposto = (float) (salario * (salario * 0.07 - (50 * qtdeDependentes)));
        }
        if (imposto < 0) {
            imposto = 0;
        }
        return imposto;
    }

}
