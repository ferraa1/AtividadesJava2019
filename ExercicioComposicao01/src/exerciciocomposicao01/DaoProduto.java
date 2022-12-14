package exerciciocomposicao01;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoProduto extends Dao {
    
    public boolean inserir(Produto p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean editar(Produto p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean excluir(Produto p) {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public List<Produto> listar() {
        return em.createQuery("select p from produto p").getResultList();
    }
    
    public Produto selecionar(int codigo) {
        try {
            Query consulta = em.createQuery("select p from produto p where p.codigo = :codigo");
            consulta.setParameter("codigo", codigo);
            return (Produto)consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
