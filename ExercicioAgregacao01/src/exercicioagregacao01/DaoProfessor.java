package exercicioagregacao01;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoProfessor extends Dao {

    public boolean inserir(Professor p) {
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

    public Professor selecionar(int matricula) {
        try {
            Query consulta = em.createQuery("select p from Professor p where p.matricula = :matri");
            consulta.setParameter("matri", matricula);
            return (Professor) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
