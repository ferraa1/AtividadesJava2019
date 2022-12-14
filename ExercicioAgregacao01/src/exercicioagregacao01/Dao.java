package exercicioagregacao01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExercicioAgregacao01PU");
    protected EntityManager em = emf.createEntityManager();

}
