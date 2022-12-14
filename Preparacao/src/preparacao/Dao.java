package preparacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
    
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreparacaoPU");
    protected EntityManager em = emf.createEntityManager();
}
