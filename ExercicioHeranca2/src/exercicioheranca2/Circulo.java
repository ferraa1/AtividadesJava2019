package exercicioheranca2;

public class Circulo extends Figura {
    
    private float raio;

    public Circulo() {
    }

    public Circulo(float raio, String cor) {
        super(cor);
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return super.toString() + " Circulo{" + "raio=" + raio + '}';
    }
    
    @Override
    public float getArea() {
        return (float) (3.14 * raio * raio);
    }
    
    @Override
    public float getPerimetro() {
        return (float) (6.28 * raio);
    }
    
}
