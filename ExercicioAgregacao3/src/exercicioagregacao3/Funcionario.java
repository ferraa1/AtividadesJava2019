package exercicioagregacao3;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String nome;
    private char sexo;
    private float horasTrabalhadas;
    private float valorHora;
    private Endereco endereco;
    private List<Dependente> dependentes = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, char sexo, float horasTrabalhadas, float valorHora, Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dependente> getDependente() {
        return dependentes;
    }

    public void setDependente(List<Dependente> dependente) {
        this.dependentes = dependente;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", sexo="
                + sexo + ", horasTrabalhadas=" + horasTrabalhadas
                + ", valorHora=" + valorHora + ", endereco="
                + endereco.toString() + '}';
    }

    public void addDependente(Dependente d) {
        dependentes.add(d);
    }

    public float calculaSalarioBruto() {
        return horasTrabalhadas * valorHora + (50 * dependentes.size());
    }

    public float calculaDescontoInss() {
        if (calculaSalarioBruto() <= 1000) {
            return (float) (calculaSalarioBruto() * 8.5 / 100);
        } else {
            return (float) (calculaSalarioBruto() * 9 / 100);  
        }
    }

    public float calculaDescontoIr() {
        if (calculaSalarioBruto() <= 500) {
            return 0;
        } else if (calculaSalarioBruto() > 500 && calculaSalarioBruto() <= 1000) {
            return (float) (calculaSalarioBruto() * 5 / 100);
        } else {
            return (float) (calculaSalarioBruto() * 7 / 100);
        }
    }

}
