package test;

import entity.Navn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Testing {

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNamedQuery("names.findAll");
        List<Navn> names = q.getResultList();
        for (Navn name : names)
        {
            System.out.println(name);
        }
    }
}
