package exerciciocomposicao01;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoNotaFiscal extends Dao {

    public boolean inserir(NotaFiscal n) {
        try {
            em.getTransaction().begin();
            em.persist(n);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public List<NotaFiscal> listarCliente(Cliente cli) {
        try {
            Query consulta = em.createQuery("select n from nota_fiscal n where n.cliente = :cli");
            consulta.setParameter("cli", cli);
            return consulta.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<NotaFiscal> listar() {
        return em.createQuery("select n from nota_fiscal n").getResultList();
    }

    public NotaFiscal selecionar(int codigo) {
        try {
            Query consulta = em.createQuery("select n from nota_fiscal n where n.codigo = :codigo");
            consulta.setParameter("codigo", codigo);
            return (NotaFiscal)consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
