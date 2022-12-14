package exercicioagregacao01;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int matricula;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String formacao;

    public Professor() {
    }

    public Professor(int matricula, String nome, String cpf, String dataNascimento, String formacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor{" + "matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", formacao=" + formacao + '}';
    }

}
