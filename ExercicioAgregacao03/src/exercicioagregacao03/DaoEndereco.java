package exercicioagregacao03;

import javax.persistence.PersistenceException;

public class DaoEndereco extends Dao {

    public boolean inserir(Endereco d) {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
}
