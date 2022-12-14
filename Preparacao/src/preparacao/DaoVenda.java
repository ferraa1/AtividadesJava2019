package preparacao;

import java.util.List;
import javax.persistence.PersistenceException;

public class DaoVenda extends Dao {
    
    public boolean inserir(Venda v) {
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public List<Venda> listar() {
        return em.createQuery("select v from Venda v").getResultList();
    }
}
