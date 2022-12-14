package exerciciocomposicao01;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DaoCliente daoc = new DaoCliente();
        DaoProduto daop = new DaoProduto();
        DaoNotaFiscal daon = new DaoNotaFiscal();
        int opcao = 0;
        int mensagem = 1;

        do {
            System.out.println("·----------·----------·----------·----------·----------·");
            System.out.println("0 - Sair\n1 - Cadastrar cliente\n2 - Editar cliente\n 3 - Excluir cliente\n"
                    + "4 - Listar clientes\n5 - Cadastrar produto\n6 - Editar produto\n7 - Excluir produto\n"
                    + "8 - Listar produtos\n9 - Gerar nota fiscal\n10 - Listagem de notas por dia\n"
                    + "11 - Mostrar nota específica\n12 - Listagem de notas por cliente");
            switch (opcao) {
                case 1: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Data de nascimento: ");
                    String dataNascimento = sc.next();
                    Cliente c = new Cliente(cpf, nome, dataNascimento);
                    if (daoc.inserir(c)) {
                        mensagem = 2;
                    }
                    break;
                }
                case 2: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    Cliente c = daoc.selecionar(cpf);
                    if (c != null) {
                        System.out.print("Novo nome: ");
                        String nome = sc.next();
                        c.setNome(nome);
                        if (daoc.editar(c)) {
                            mensagem = 2;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    Cliente c = daoc.selecionar(cpf);
                    if (c != null) {
                        if (daoc.excluir(c)) {
                            mensagem = 2;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    for (Cliente c : daoc.listar()) {
                        c.toString();
                    }
                    mensagem = 0;
                    break;
                }
                case 5: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    System.out.print("Descrição: ");
                    String descricao = sc.next();
                    System.out.print("Valor unitário: ");
                    double valorUnitario = sc.nextDouble();
                    Produto p = new Produto(codigo, descricao, valorUnitario);
                    if (daop.inserir(p)) {
                        mensagem = 2;
                    }
                    break;
                }
                case 6: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    Produto p = daop.selecionar(codigo);
                    if (p != null) {
                        System.out.print("Nova descrição: ");
                        String descricao = sc.next();
                        p.setDescricao(descricao);
                        System.out.print("Novo valor: ");
                        double valorUnitario = sc.nextDouble();
                        p.setValorUnitario(valorUnitario);
                        if (daop.editar(p)) {
                            mensagem = 2;
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    Produto p = daop.selecionar(codigo);
                    if (p != null) {
                        if (daop.excluir(p)) {
                            mensagem = 2;
                        }
                    }
                    break;
                }
                case 8: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    for (Produto p : daop.listar()) {
                        p.toString();
                    }
                    mensagem = 0;
                    break;
                }
                case 9: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Código da nota: ");
                    int codigo = sc.nextInt();
                    System.out.print("Data da nota: ");
                    String data = sc.next();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.next();
                    Cliente cli = daoc.selecionar(cpf);
                    char opcao2 = 0;
                    double valorTotal = 0;
                    double descontos = 0;
                    if (cli != null) {
                        NotaFiscal nf = new NotaFiscal(codigo, data, cli);
                        do {
                            System.out.print("Quantidade do item: ");
                            int quantidade = sc.nextInt();
                            System.out.print("Desconto do item: ");
                            double desconto = sc.nextDouble();
                            System.out.print("Código do produto: ");
                            int codigoP = sc.nextInt();
                            Produto p = daop.selecionar(codigoP);
                            if (p != null) {
                                nf.addItens(quantidade, desconto, p);
                                valorTotal += quantidade * p.getValorUnitario();
                                descontos += desconto;
                                System.out.print("Deseja informar outro? (s/n): ");
                                opcao2 = sc.next().charAt(0);
                            } else {
                                System.out.println("Erro!");
                            }
                        } while (opcao2 != 'n');
                        System.out.println("Valor total: " + valorTotal);
                        System.out.println("Descontos: " + descontos);
                        System.out.println("Valor final: " + (valorTotal - descontos));
                        if (daon.inserir(nf)) {
                            mensagem = 2;
                        }
                    } else {
                        System.out.println("Erro!");
                    }
                    mensagem = 0;
                    break;
                }
                case 10: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    for (NotaFiscal nf : daon.listar()) {
                        if (Integer.parseInt(nf.getData().substring(0, 2)) == dia) {
                            System.out.println(nf.toString());
                            for (ItemNota in : nf.getItens()) {
                                System.out.println(in.toString());
                            }
                        }
                    }
                    mensagem = 0;
                    break;
                }
                case 11: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    NotaFiscal nf = daon.selecionar(codigo);
                    System.out.println(nf.toString());
                    for (ItemNota in : nf.getItens()) {
                        System.out.println(in.toString());
                    }
                    mensagem = 0;
                    break;
                }
                case 12: {
                    System.out.println("·----------·----------·----------·----------·----------·");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    for (NotaFiscal nf : daon.listar()) {
                        if (nf.getCliente().getCpf() == cpf) {
                            System.out.println(nf.toString());
                            for (ItemNota in : nf.getItens()) {
                                System.out.println(in.toString());
                            }
                        }
                    }
                    mensagem = 0;
                    break;
                }
            }
            if (mensagem == 1 && opcao != 0) {
                System.out.println("Erro!");
            } else if (mensagem == 2 && opcao != 0) {
                System.out.println("Sucesso!");
            }
            mensagem = 1;
        } while (opcao != 0);

    }

}
