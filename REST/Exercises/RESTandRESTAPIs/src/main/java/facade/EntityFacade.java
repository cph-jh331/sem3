package facade;

import entity.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EntityFacade {

    private EntityManagerFactory emf;

    public EntityFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public List<Pet> getAllPets()
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createNamedQuery("Pet.findAll");
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }

    public List<Pet> getAllLivingPets()
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createNamedQuery("Pet.findAllLiving");
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }

}
