package exercicioheranca1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("··· Opções ···");
            System.out.println("0 - Sair\n1 - Cadastrar pessoa\n2 - Listar pessoas");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("··· Cadastrar pessoa ···");
                    int opcaoP = 0;
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Telefone: ");
                    String telefone = sc.next();
                    System.out.print("Endereço: ");
                    String endereco = sc.next();
                    System.out.println("1 - Pessoa física\n2 - Pessoa jurídica");
                    if (opcaoP == 1) {
                        System.out.println("··· Pessoa física ···");
                        System.out.print("CPF: ");
                        String cpf = sc.next();
                        System.out.print("RG: ");
                        String rg = sc.next();
                        System.out.print("Salario: ");
                        float salario = sc.nextFloat();
                        System.out.print("Quantidade de dependentes: ");
                        int qtdeDependentes = sc.nextInt();
                        Pessoa p = new PessoaFisica(cpf, rg, salario, qtdeDependentes, nome, telefone, endereco);
                        pessoas.add(p);
                    } else {
                        System.out.println("··· Pessoa jurídica ···");
                        System.out.print("CNPJ: ");
                        String cnpj = sc.next();
                        System.out.print("Faturamento do mês: ");
                        float faturamentomes = sc.nextFloat();
                        System.out.print("Categoria (1 = Supersimples / 2 = Simples / 3 = Normal): ");
                        int categoria = sc.nextInt();
                        Pessoa p = new PessoaJuridica(cnpj, faturamentomes, categoria, nome, telefone, endereco);
                        pessoas.add(p);
                    }
                    break;
                }
                case 2: {
                    System.out.println("··· Listar pessoas ···");
                    for (Pessoa p : pessoas) {
                        System.out.println(p.toString() + ", imposto=" + p.getImpostoDevido() + "}");
                    }
                    break;
                }
            }
        } while (opcao != 0);

    }

}
