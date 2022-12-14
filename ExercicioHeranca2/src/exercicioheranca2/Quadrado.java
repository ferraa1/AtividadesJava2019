package exercicioheranca2;

public class Quadrado extends Figura {
    
    private float lado;

    public Quadrado() {
    }

    public Quadrado(float lado, String cor) {
        super(cor);
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return super.toString() + " Quadrado{" + "lado=" + lado + '}';
    }
    
    @Override
    public float getArea() {
        return lado*lado;
    }
    
    @Override
    public float getPerimetro() {
        return lado*4;
    }
    
}
