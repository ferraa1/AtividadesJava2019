package exemploheranca;

public class Sistema {
    
    public static void main(String[] args) {
        
        Veiculo v = new Carro(4, "aaa-1234", 2018, "Azul", "Gol");
        
        mensagem(v);
        
        v = new Moto(125, "bbbb-1234", 2019, "Preta", "Biz");
        
        mensagem(v);
        
    }

    private static void mensagem(Veiculo v) {
        System.out.print(v.toString());
        System.out.println(" ··· " +v.ondeAcelera());
    }
}
