package exemploheranca;

public class Moto extends Veiculo{
    
    private int cilindradas;
    
    public Moto() {
        
    }
    
    public Moto(int cilindradas, String placa, int ano, String cor, String modelo) {
        super(placa, ano, cor, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public String ondeAcelera() {
        return "Na mão";
    }
    
    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return super.toString() + " ··· Moto{" + "cilindradas=" + cilindradas + '}';
    }
    
}
