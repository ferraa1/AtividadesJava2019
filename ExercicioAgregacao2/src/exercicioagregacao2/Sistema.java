package exercicioagregacao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Revendedora> revendedoras = new ArrayList<>();
        List<Fabricante> fabricantes = new ArrayList<>();
        List<Automovel> automoveis = new ArrayList<>();
        int opcao = 0;
        do {
            System.out.println("0 - Sair\n1 - Cadastrar "
                    + "revendedora\n2 - Cadastrar fabricante\n"
                    + "3 - Cadastrar automóveis\n4 - Editar "
                    + "revendedora\n5 - Editar automóvel\n6 - "
                    + "Remover revendedora\n7 - Remover "
                    + "automóvel\n8 - Listar revendedoras\n9 - "
                    + "Listar revendedoras e seus veículos\n10 - "
                    + "Cadastrar autmóveis em uma revendedora");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Código de filiação:");
                    int codigoFiliacao = sc.nextInt();
                    System.out.println("Nome fantasia:");
                    String nomeFantasia = sc.next();
                    System.out.println("Telefone:");
                    String telefone = sc.next();
                    System.out.println("Endereço:");
                    String endereco = sc.next();
                    Revendedora r = new Revendedora(codigoFiliacao, nomeFantasia, telefone, endereco);
                    revendedoras.add(r);
                    break;
                }
                case 2: {
                    System.out.println("Nome:");
                    String nome = sc.next();
                    System.out.println("País");
                    String pais = sc.next();
                    Fabricante f = new Fabricante(nome, pais);
                    fabricantes.add(f);
                    break;
                }
                case 3: {
                    System.out.println("Placa:");
                    String placa = sc.next();
                    System.out.println("Modelo:");
                    String modelo = sc.next();
                    System.out.println("Ano:");
                    int ano = sc.nextInt();
                    System.out.println("Fabricante:");
                    String nomeFab = sc.next();
                    for (Fabricante f : fabricantes) {
                        if (f.getNome().equalsIgnoreCase(nomeFab)) {
                            Automovel a = new Automovel(placa, f, modelo, ano);
                            automoveis.add(a);
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Código da revendedora:");
                    int codigo = sc.nextInt();
                    for (Revendedora r : revendedoras) {
                        if (r.getCodigoFiliacao() == codigo) {
                            System.out.println("Novo nome:");
                            String nome = sc.next();
                            r.setNomeFantasia(nome);
                            System.out.println("Novo telefone:");
                            String telefone = sc.next();
                            r.setTelefone(telefone);
                            System.out.println("Novo endereço:");
                            String endereco = sc.next();
                            r.setEndereco(endereco);
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Placa do automóvel:");
                    String placa = sc.next();
                    for (Automovel a : automoveis) {
                        if (a.getPlaca().equalsIgnoreCase(placa)) {
                            System.out.println("Novo modelo:");
                            String modelo = sc.next();
                            a.setModelo(modelo);
                            System.out.println("Novo ano:");
                            int ano = sc.nextInt();
                            a.setAno(ano);
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Código da revendedora:");
                    int codigo = sc.nextInt();
                    for (Revendedora r : revendedoras) {
                        if (r.getCodigoFiliacao() == codigo) {
                            revendedoras.remove(r);
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("Placa do automóvel:");
                    String placa = sc.next();
                    for (Automovel a : automoveis) {
                        if (a.getPlaca().equalsIgnoreCase(placa)) {
                            automoveis.remove(a);
                            break;
                        }
                    }
                    break;
                }
                case 8: {
                    for (Revendedora r : revendedoras) {
                        System.out.println(r.toString());
                    }
                    break;
                }
                case 9: {
                    for (Revendedora r : revendedoras) {
                        System.out.println(r.toString());
                        for (Automovel a : r.getAutomoveis()) {
                            System.out.println(a.toString());
                        }
                    }
                    break;
                }
                case 10: {
                    System.out.println("Código da revendedora:");
                    int codigo = sc.nextInt();
                    for (Revendedora r : revendedoras) {
                        if (r.getCodigoFiliacao() == codigo) {
                            char continuar = 0;
                            do {
                                System.out.println("Placa do carro:");
                                String placa = sc.next();
                                int cont = 0;
                                for (Automovel a : r.getAutomoveis()) {
                                    if (a.getPlaca().equalsIgnoreCase(placa)) {
                                        r.addAutomoveis(a);
                                        cont++;
                                        break;
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("Nenhum automóvel com essa placa encontrado.");
                                }
                                System.out.println("Deseja informar outro automóvel? (s/n)");
                                continuar = sc.next().charAt(0);
                            } while (continuar == 's');
                            break;
                        }
                    }
                    break;
                }
            }
        } while (opcao != 0);
        
    }

}
