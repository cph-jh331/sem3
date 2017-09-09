package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PersonFacade implements IPersonFacade {

    private EntityManagerFactory emf;

    public PersonFacade()
    {
    }

    public PersonFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    //burde nok ikke være here, men bare være der i constructoren.
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;

    }

    @Override
    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id)
    {
        EntityManager em = getEntityManager();
        long lid = id;
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, lid);
            em.remove(p);
            em.getTransaction().commit();
            return p;

        } finally
        {
            em.close();
        }
    }

    @Override
    public Person getPerson(int id)
    {
        EntityManager em = getEntityManager();
        long lid = id;
        try
        {
            return em.find(Person.class, lid);
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons()
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createNamedQuery("Person.getAllPersons");
            List<Person> pList = q.getResultList();
            return pList;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

}
