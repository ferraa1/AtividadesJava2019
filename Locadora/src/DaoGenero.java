
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoGenero extends Dao{
    
    public boolean inserir (Genero c) {
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
    
    public boolean editar(Genero c) {
        
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
    
    public boolean excluir(Genero c) {
        
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
    
    public List<Genero> listar () {
        return em.createQuery("select c from Genero c").getResultList();
    }
    
    public Genero selecionarSemFind (String nome) {
        try {
            Query consulta = em.createQuery("select c from Genero c where c.nome = :nome");
            consulta.setParameter("nome", nome);
            return (Genero) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void fechar() {
        em.close();
        emf.close();
    }
}
