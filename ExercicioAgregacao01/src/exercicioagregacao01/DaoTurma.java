package exercicioagregacao01;

import java.util.List;
import javax.persistence.PersistenceException;

public class DaoTurma extends Dao {

    public boolean inserir(Turma t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public List<Turma> listar() {
        return em.createQuery("select t from Turma t").getResultList();
    }

}
