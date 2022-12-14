package exercicioheranca2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Figura> figuras = new ArrayList<>();
        int opcao = 0;
        
        do {
            System.out.println("0 - Sair\n1 - Cadastrar figura\n2 - Listar figuras\n3 - Listar áreas\n4 - Listar Perímetros");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    Figura f = null;
                    int formato = 0;
                    System.out.println("1 - Quadrado\n2 - Círculo");
                    System.out.print("Cor: ");
                    String cor = sc.next();
                    if (formato == 1) {
                        System.out.print("Lado: ");
                        float lado = sc.nextFloat();
                        f = new Quadrado(lado, cor);
                    } else {
                        System.out.print("Raio: ");
                        float raio = sc.nextFloat();
                        f = new Circulo(raio, cor);
                    }
                    figuras.add(f);
                    break;
                }
                case 2: {
                    for (Figura f : figuras) {
                        System.out.println(f.toString());
                    }
                    break;
                }
                case 3: {
                    for (Figura f : figuras) {
                        System.out.println(f.toString() + " Área: " + f.getArea());
                    }
                    break;
                }
                case 4: {
                    for (Figura f : figuras) {
                        System.out.println(f.toString() + " Perímetro: " + f.getPerimetro());
                    }
                    break;
                }
            }
        } while (opcao != 0);
        
    }

}
