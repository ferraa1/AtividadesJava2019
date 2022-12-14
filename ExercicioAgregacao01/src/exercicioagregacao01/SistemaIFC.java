package exercicioagregacao01;

import java.util.Scanner;

public class SistemaIFC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DaoProfessor daop = new DaoProfessor();
        DaoTurma daot = new DaoTurma();
        int opcao;
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
                    if (daop.inserir(p)) {
                        System.out.println("Cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar!");
                    }
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
                    System.out.println("Matrícula do professor:");
                    int matriculaProf = sc.nextInt();
                    Professor p = daop.selecionar(matriculaProf);
                    if (p != null) {
                        Turma t = new Turma(codigo, curso, anoIngresso, p);
                        char continuar;
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
                        if (daot.inserir(t)) {
                            System.out.println("Cadastrado com sucesso!");
                        } else {
                            System.out.println("Erro ao cadastrar!");
                        }
                    } else {
                        System.out.println("Professor não encontrado!");
                    }
                    break;
                }
                case 3: {
                    for (Turma t : daot.listar()) {
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
