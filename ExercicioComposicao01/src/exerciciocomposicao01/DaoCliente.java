package exerciciocomposicao01;

import java.util.List;
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
    
    public boolean editar(Cliente c) {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean excluir(Cliente c) {
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public List<Cliente> listar() {
        return em.createQuery("select c from cliente c").getResultList();
    }
    
    public Cliente selecionar(String cpf) {
        try {
            Query consulta = em.createQuery("select c from cliente c where c.cpf = :cpf");
            consulta.setParameter("cpf", cpf);
            return (Cliente)consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
