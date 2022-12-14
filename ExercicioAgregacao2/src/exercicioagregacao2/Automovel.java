package exercicioagregacao2;

public class Automovel {
    
    private String placa;
    private Fabricante fabricante;
    private String modelo;
    private int ano;

    public Automovel() {
    }

    public Automovel(String placa, Fabricante fabricante, String modelo, int ano) {
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Automovel{" + "placa=" + placa + ", fabricante=" + fabricante.getNome() + ", modelo=" + modelo + ", ano=" + ano + '}';
    }
    
}
