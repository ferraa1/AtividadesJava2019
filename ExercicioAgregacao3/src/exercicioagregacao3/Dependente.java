package exercicioagregacao3;

public class Dependente {
    
    private String nome;
    private String cpf;
    private int idade;

    public Dependente() {
    }

    public Dependente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Dependente{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + '}';
    }
    
}
