
import java.util.Calendar;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DaoGenero daog = new DaoGenero();
        DaoCliente daoc = new DaoCliente();
        DaoAluguel daoa = new DaoAluguel();
        DaoFilme daof = new DaoFilme();
        int opcao = 0;

        do {
            System.out.println("---------------------------------------------");
            System.out.println("Opção:\n"
                    + "1 - Cadastrar gênero.\n"
                    + "2 - Editar gênero.\n"
                    + "3 - Excluir gênero.\n"
                    + "4 - Cadastrar cliente.\n"
                    + "5 - Editar cliente.\n"
                    + "6 - Excluir cliente.\n"
                    + "7 - Cadastrar filme.\n"
                    + "8 - Editar filme.\n"
                    + "9 - Excluir filme.\n"
                    + "10 - Cadastrar aluguel.\n"
                    + "11 - Listar filmes de um determinado gênero.\n"
                    + "12 - Listar alugueis de filmes de uma determinada data.\n"
                    + "13 - Listar alugueis com devolução para a data atual.\n"
                    + "14 - Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Classificação: ");
                    int classificacao = sc.nextInt();
                    Genero g = new Genero(nome, classificacao);
                    if (daog.inserir(g)) {
                        System.out.println("Gênero cadastrado.");
                    } else {
                        System.out.println("Erro ao cadastrar.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Nome do gênero a ser editado: ");
                    String nome = sc.next();
                    Genero g = daog.selecionarSemFind(nome);
                    if (g != null) {
                        System.out.print("Nova classificação: ");
                        int classificacao = sc.nextInt();
                        g.setClassificacao(classificacao);
                        if (daog.editar(g)) {
                            System.out.println("Editado com sucesso.");
                        } else {
                            System.out.println("Erro ao editar.");
                        }
                    } else {
                        System.out.println("Gênero não encontrado.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Nome do gênero a ser excluido: ");
                    String nome = sc.next();
                    Genero g = daog.selecionarSemFind(nome);
                    if (g != null) {
                        if (daog.excluir(g)) {
                            System.out.println("Excluido com sucesso.");
                        } else {
                            System.out.println("Erro ao excluir.");
                        }
                    } else {
                        System.out.println("Gênero não encontrado.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("---------------------------------------------");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Telefone: ");
                    String fone = sc.next();
                    System.out.print("Data de nascimento: ");
                    String dataNasc = sc.next();
                    Cliente c = new Cliente(cpf, nome, email, fone, dataNasc);
                    if (daoc.inserir(c)) {
                        System.out.println("Cliente cadastrado.");
                    } else {
                        System.out.println("Erro ao cadastrar.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("---------------------------------------------");
                    System.out.print("CPF do cliente a ser editado: ");
                    String cpf = sc.next();
                    Cliente c = daoc.selecionarSemFind(cpf);
                    if (c != null) {
                        System.out.print("Nome: ");
                        String nome = sc.next();
                        c.setNome(nome);
                        System.out.print("Email: ");
                        String email = sc.next();
                        c.setEmail(email);
                        System.out.print("Telefone: ");
                        String fone = sc.next();
                        c.setTelefone(fone);
                        System.out.print("Data de nascimento: ");
                        String dataNasc = sc.next();
                        c.setDataNascimento(dataNasc);
                        if (daoc.editar(c)) {
                            System.out.println("Editado com sucesso.");
                        } else {
                            System.out.println("Erro ao editar.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("---------------------------------------------");
                    System.out.print("CPF do cliente a ser excluido: ");
                    String cpf = sc.next();
                    Cliente c = daoc.selecionarSemFind(cpf);
                    if (c != null) {
                        if (daoc.excluir(c)) {
                            System.out.println("Excluido com sucesso.");
                        } else {
                            System.out.println("Erro ao excluir.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                }
                case 7: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    System.out.print("Título: ");
                    String titulo = sc.next();
                    System.out.print("Sinopse: ");
                    String sinopse = sc.next();
                    System.out.print("Ano de lançamento: ");
                    int anoLan = sc.nextInt();
                    System.out.print("Duração: ");
                    int duracao = sc.nextInt();
                    System.out.print("Gênero do filme: ");
                    String nomeGenero = sc.next();
                    Genero g = daog.selecionarSemFind(nomeGenero);
                    if (g != null) {
                        Filme f = new Filme(codigo, titulo, sinopse, anoLan, duracao, g);
                        if (daof.inserir(f)) {
                            System.out.println("Filme cadastrado.");
                        } else {
                            System.out.println("Erro ao cadastrar.");
                        }
                    } else {
                        System.out.println("Gênero não encontrado.");
                    }
                    break;
                }
                case 8: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Informe o código do filme a ser editado: ");
                    int codigo = sc.nextInt();
                    Filme f = daof.selecionarSemFind(codigo);
                    if (f != null) {
                        System.out.print("Título: ");
                        String titulo = sc.next();
                        f.setTitulo(titulo);
                        System.out.print("Sinopse: ");
                        String sinopse = sc.next();
                        f.setSinopse(sinopse);
                        System.out.print("Ano de lançamento: ");
                        int anoLan = sc.nextInt();
                        f.setAnoLancamento(anoLan);
                        System.out.print("Duração: ");
                        int duracao = sc.nextInt();
                        f.setDuracao(duracao);
                        if (daof.editar(f)) {
                            System.out.println("Editado com sucesso.");
                        } else {
                            System.out.println("Erro ao editar.");
                        }
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break; //FALTOU EDITAR O GÊNERO, SEU PREGUIÇOSO!
                }
                case 9: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Informe o código do filme a ser excluido: ");
                    int codigo = sc.nextInt();
                    Filme f = daof.selecionarSemFind(codigo);
                    if (f != null) {
                        if (daof.excluir(f)) {
                            System.out.println("Excluido com sucesso.");
                        } else {
                            System.out.println("Erro ao excluir.");
                        }
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                }
                case 10: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    System.out.print("Data (00/00/0000): ");
                    String data = sc.next();
                    System.out.print("CPF do cliente: ");
                    String cpfC = sc.next();
                    Cliente c = daoc.selecionarSemFind(cpfC);
                    System.out.print("Código do filme: ");
                    int codigoF = sc.nextInt();
                    Filme f = daof.selecionarSemFind(codigoF);
                    if (f != null || c != null) {
                        Aluguel a = new Aluguel(codigo, data, c, f);
                        if (a.verificaAluguel()) {
                            if (daoa.inserir(a)) {
                                System.out.println("Aluguel cadastrado.");
                            } else {
                                System.out.println("Erro ao cadastrar.");
                            }
                        } else {
                            System.out.println("O cliente não pode alugar filmes desse gênero.");
                        }
                    } else {
                        System.out.println("Filme e/ou Cliente não encontrado/os.");
                    }
                    break;
                }
                case 11: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Gênero: ");
                    String nome = sc.next();
                    Genero g = daog.selecionarSemFind(nome);
                    if (g != null) {
                        for (Filme filme : daof.listar()) {
                            if (filme.getGenero() == (g)) {
                                System.out.println(filme.toString());
                            }
                        }
                    } else {
                        System.out.println("Nenhum filme com esse gênero encontrado.");
                    }
                    break;
                }
                case 12: {
                    System.out.println("---------------------------------------------");
                    System.out.print("Data de aluguel: ");
                    String data = sc.next();
                    for (Aluguel aluguel : daoa.listar(data)) {
                        System.out.println(aluguel.toString());
                    }
                    break;
                }
                case 13: {
                    System.out.println("---------------------------------------------");
                    Calendar gc = Calendar.getInstance();
                    String calendario = gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get((Calendar.MONTH) + 1) + "/" + gc.get(Calendar.YEAR);//No Calendar, Mês começa por 00 e não 01.
                    for (Aluguel aluguel : daoa.listar()) {
                        if (aluguel.calcularDataDevolucao().equals(calendario)) {
                            System.out.println(aluguel.toString());
                        }
                    }
                    break;
                }
                case 14: {
                    System.out.println("BYE!");
                    break;
                }
                default: {
                    System.out.println("...");
                }
            }
        } while (opcao != 14);

        daog.fechar();
        daoc.fechar();
        daoa.fechar();
        daof.fechar();

    }
}
