package exemploheranca;

public abstract class Veiculo {
    
    private String placa;
    private int ano;
    private String cor;
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String placa, int ano, String cor, String modelo) {
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
    }
    
    public abstract String ondeAcelera();
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", ano=" + ano + ", cor=" + cor + ", modelo=" + modelo + '}';
    }
    
}
