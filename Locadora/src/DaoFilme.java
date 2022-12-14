
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoFilme extends Dao{
    
    public boolean inserir (Filme c) {
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
    
    public boolean editar(Filme c) {
        
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
    
    public boolean excluir(Filme c) {
        
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
    
    public List<Filme> listar () {
        return em.createQuery("select c from Filme c").getResultList();
    }
    
    public Filme selecionarSemFind (int codigo) {
        try {
            Query consulta = em.createQuery("select c from Filme c where c.codigo = :codigo");
            consulta.setParameter("codigo", codigo);
            return (Filme) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void fechar() {
        em.close();
        emf.close();
    }
}
