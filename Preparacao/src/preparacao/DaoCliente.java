package preparacao;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoCliente extends Dao {
    
    public boolean inserir(Cliente c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public Cliente selecionar(String cpf) {
        try {
            Query consulta = em.createQuery("select c from Cliente c where c.cpf = :cpf");
            consulta.setParameter("cpf", cpf);
            return (Cliente) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
