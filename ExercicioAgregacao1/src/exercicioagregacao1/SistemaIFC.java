package exercicioagregacao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaIFC {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Turma> turmas = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        int opcao = 0;
        do {
            System.out.println("0 - Sair\n1 - Cadastrar professor\n2- Cadastrar turma\n3 - Listar turmas");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Professor:");
                    System.out.println("Matrícula:");
                    int matricula = sc.nextInt();
                    System.out.println("Nome:");
                    String nome = sc.next();
                    System.out.println("CPF:");
                    String cpf = sc.next();
                    System.out.println("Data de nascimento:");
                    String dataNascimento = sc.next();
                    System.out.println("Formação:");
                    String formacao = sc.next();
                    Professor p = new Professor(matricula, nome, cpf, dataNascimento, formacao);
                    professores.add(p);
                    break;
                }
                case 2: {
                    System.out.println("Turma:");
                    System.out.println("Código:");
                    int codigo = sc.nextInt();
                    System.out.println("Curso:");
                    String curso = sc.next();
                    System.out.println("Ano de ingresso:");
                    int anoIngresso = sc.nextInt();
                    System.out.println("Professor:");
                    String nomeProf = sc.next();
                    Professor p = null;
                    for (Professor pro : professores) {
                        if (pro.getNome().equals(nomeProf)) {
                            p = pro;
                            break;
                        }
                    }
                    Turma t = new Turma(codigo, curso, anoIngresso, p);
                    char continuar = 0;
                    do {
                        System.out.println("Aluno:");
                        System.out.println("Matrícula:");
                        int matricula = sc.nextInt();
                        System.out.println("Nome:");
                        String nome = sc.next();
                        System.out.println("CPF:");
                        String cpf = sc.next();
                        System.out.println("RG:");
                        String rg = sc.next();
                        System.out.println("Data de nascimento:");
                        String dataNascimento = sc.next();
                        Aluno a = new Aluno(matricula, nome, cpf, rg, dataNascimento);
                        t.addAluno(a);
                        System.out.println("Deseja informar outro aluno? (s/n)");
                        continuar = sc.next().charAt(0);
                    } while (continuar == 's');
                    turmas.add(t);
                    break;
                }
                case 3: {
                    for (Turma t : turmas) {
                        System.out.println(t.toString());
                        for (Aluno a : t.getAlunos()) {
                            System.out.println(a.toString());
                        }
                    }
                    break;
                }
            }
        } while (opcao != 0);
        
    }

}
