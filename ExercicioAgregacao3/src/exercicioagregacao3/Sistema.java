package exercicioagregacao3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();
        int opcao = 0;
        do {
            System.out.println("0 - Sair\n1 - Cadastrar Funcionário\n2 - Listar Funcionários");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Nome:");
                    String nome = sc.next();
                    System.out.println("Sexo (f/m):");
                    char sex = sc.next().charAt(0);
                    System.out.println("Horas trabalhadas:");
                    float horasTrabalhadas = sc.nextFloat();
                    System.out.println("Valor hora:");
                    float valorHora = sc.nextFloat();
                    System.out.println("Endereço:");
                    System.out.println("Rua:");
                    String rua = sc.next();
                    System.out.println("Bairro:");
                    String bairro = sc.next();
                    System.out.println("Cidade:");
                    String cidade = sc.next();
                    Endereco e = new Endereco(rua, bairro, cidade);
                    Funcionario f = new Funcionario(nome, sex, horasTrabalhadas, valorHora, e);
                    char continuar = 0;
                    do {
                        System.out.println("Dependente:");
                        System.out.println("Nome:");
                        String nomeDep = sc.next();
                        System.out.println("CPF:");
                        String cpf = sc.next();
                        System.out.println("Idade:");
                        int idade = sc.nextInt();
                        Dependente d = new Dependente(nomeDep, cpf, idade);
                        f.addDependente(d);
                        System.out.println("Deseja adicionar outro dependente? (s/n)");
                        continuar = sc.next().charAt(0);
                    } while (continuar == 's');
                    funcionarios.add(f);
                    break;
                }
                case 2: {
                    for (Funcionario f : funcionarios) {
                        float salB = f.calculaSalarioBruto();
                        float inss = f.calculaDescontoInss();
                        float ir = f.calculaDescontoIr();
                        float salL = (salB - inss - ir);
                        System.out.println(f.toString());
                        System.out.println("Salário bruto = " + salB + ", Desconto INSS = " + inss + ", Desconto IR = " + ir + ", Salário líquido = " + salL);
                        for (Dependente d : f.getDependente()) {
                            System.out.println(d.toString());
                        }
                    }
                    break;
                }
            }
        } while (true);
        
    }

}
