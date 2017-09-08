package facade;

import entity.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EntityFacade {

    EntityManagerFactory emf;

    public EntityFacade()
    {

    }

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
            List<Pet> petList = q.getResultList();
            return petList;

        } finally
        {
            em.close();
        }
    }

}
