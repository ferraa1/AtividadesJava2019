package exercicioagregacao03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private char sexo;
    @Column(name = "horas_trabalhadas")
    private float horasTrabalhadas;
    @Column(name = "valor_hora")
    private float valorHora;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario")
    private List<Dependente> dependentes = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    public Funcionario() {
    }

    public Funcionario(String nome, char sexo, float horasTrabalhadas, float valorHora, Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", horasTrabalhadas=" + horasTrabalhadas + ", valorHora=" + valorHora + ", dependentes=" + dependentes + ", endereco=" + endereco + '}';
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
