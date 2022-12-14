
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sistema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FutebolPU");
        EntityManager em = emf.createEntityManager();
        int opcao = 0;
        do {
            System.out.println("1 - Cadastrar time\n2 - Listar time");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Nome do time:");
                    String nome = sc.next();
                    Time t = new Time(nome);
                    char continua = 0;
                    do {
                        System.out.println("Nome do atleta:");
                        String nomeAtleta = sc.next();
                        System.out.println("Idade:");
                        int idade = sc.nextInt();
                        Atleta a = new Atleta(nome, idade, t);
                        t.addAtleta(a);
                        System.out.println("Deseja adicionar mais atletas?");
                        continua = sc.next().charAt(0);
                    } while (continua == 's');
                    em.getTransaction().begin();
                    em.persist(continua);
                    em.getTransaction().commit();
                    break;
                }
                case 2: {
                    List<Time> times = em.createQuery("select t from Time t").getResultList();
                    for (Time t : times) {
                        System.out.println(t.toString());
                        for (Atleta a : t.getAtletas()) {
                            System.out.println(a.toString());
                        }
                    }
                    break;
                }
            }
        } while (opcao != 0);

    }
}
