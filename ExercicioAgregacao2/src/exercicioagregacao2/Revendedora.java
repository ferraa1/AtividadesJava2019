package exercicioagregacao2;

import java.util.ArrayList;
import java.util.List;

public class Revendedora {
    
    private int codigoFiliacao;
    private String nomeFantasia;
    private String telefone;
    private String endereco;
    private List<Automovel> automoveis = new ArrayList<>();

    public Revendedora() {
    }

    public Revendedora(int codigoFiliacao, String nomeFantasia, String telefone, String endereco) {
        this.codigoFiliacao = codigoFiliacao;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getCodigoFiliacao() {
        return codigoFiliacao;
    }

    public void setCodigoFiliacao(int codigoFiliacao) {
        this.codigoFiliacao = codigoFiliacao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    @Override
    public String toString() {
        return "Revendedora{" + "codigoFiliacao=" + codigoFiliacao + ", nomeFantasia=" + nomeFantasia + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
    
    public void addAutomoveis (Automovel a) {
        automoveis.add(a);
    }
}
