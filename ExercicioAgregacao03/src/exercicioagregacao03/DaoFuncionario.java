package exercicioagregacao03;

import java.util.List;
import javax.persistence.PersistenceException;

public class DaoFuncionario extends Dao {

    public boolean inserir(Funcionario f) {
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public List<Funcionario> listar() {
        return em.createQuery("select f from Funcionario f").getResultList();
    }
}
