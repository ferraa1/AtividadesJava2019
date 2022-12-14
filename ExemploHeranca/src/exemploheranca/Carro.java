package exemploheranca;

public class Carro extends Veiculo{
    
    private int qtdePortas;
    
    public Carro() {
        
    }
    
    public Carro(int qtdePortas, String placa, int ano, String cor, String modelo) {
        super(placa, ano, cor, modelo); //super = classe pai
        this.qtdePortas = qtdePortas;
    }
    
    @Override
    public String ondeAcelera() {
        return "No pé";
    }
    
    public int getQtdePortas() {
        return qtdePortas;
    }

    public void setQtdePortas(int qtdePortas) {
        this.qtdePortas = qtdePortas;
    }

    @Override
    public String toString() {
        return super.toString() + " ··· Carro{" + "qtdePortas=" + qtdePortas + '}';
    }
    
}
