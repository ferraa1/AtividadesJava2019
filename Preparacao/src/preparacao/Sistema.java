package preparacao;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        DaoCliente daoc = new DaoCliente();
        DaoVenda daov = new DaoVenda();

        do {

            System.out.println("··········IBIMASTER.SYSTEM··········");
            System.out.println("0 - SAIR\n1 - CADASTRAR CLIENTE\n2 - CADASTRAR VENDA\n3 - LISTAR VENDAS");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {

                    System.out.println("··········CADASTRAR.CLIENTE··········");
                    System.out.print("NOME: ");
                    String nome = sc.next();
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    System.out.print("DATA DE NASCIMENTO (YYYY/MM/DD): ");
                    String dataNascimento = sc.next();
                    Cliente c = new Cliente(cpf, nome, dataNascimento);
                    if (daoc.inserir(c)) {
                        System.out.println("CLIENTE CADASTRADO!");
                    } else {
                        System.out.println("ERRO NO CADASTRO!");
                    }
                    break;
                }
                case 2: {

                    System.out.println("··········CADASTRAR.VENDA··········");
                    System.out.print("CPF DO CLIENTE: ");
                    String cpf = sc.next();
                    Cliente c = daoc.selecionar(cpf);
                    if (c != null) {
                        System.out.print("DATA (YYYY/MM/DD): ");
                        String data = sc.next();
                        System.out.print("VALOR: ");
                        double valor = sc.nextDouble();
                        Venda v = new Venda(data, false, valor, 0, c);
                        System.out.print("TIPO DE PAGAMENTO: ");
                        
                        do {
                            
                        } while (true);
                        
                    } else {
                        System.out.println("CLIENTE NÃO ENCONTRADO!");
                    }
                    break;
                }
                case 3: {

                    System.out.println("··········LISTAR.VENDAS··········");

                    break;
                }
            }
        } while (opcao != 0);

    }

}
