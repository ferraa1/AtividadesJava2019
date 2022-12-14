
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoAluguel extends Dao {

    public boolean inserir(Aluguel c) {
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

    public boolean editar(Aluguel c) {

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

    public boolean excluir(Aluguel c) {

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

    public List<Aluguel> listar() {
        return em.createQuery("select c from Aluguel c").getResultList();
    }

    public List<Aluguel> listar(String data) {
        Query consulta = em.createQuery("select a from Aluguel a where a.data = :d");
        consulta.setParameter("d", data);
        return consulta.getResultList();
    }
    
    public Aluguel selecionar(int id) {
        return em.find(Aluguel.class, id);
    }
    
    public Aluguel selecionarSemFind(int codigo) {
        try {
            Query consulta = em.createQuery("select c from Aluguel c where c.codigo = :codigo");
            consulta.setParameter("codigo", codigo);
            return (Aluguel) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
