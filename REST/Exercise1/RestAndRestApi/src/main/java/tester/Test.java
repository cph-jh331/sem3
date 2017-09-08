package tester;

import entity.Pet;
import facade.EntityFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sem3_RestAndRestApi_war_1.0PU");
        EntityFacade ef = new EntityFacade(emf);

        List<Pet> petList = ef.getAllPets();
        for (Pet pet : petList)
        {
            System.out.println(pet);
        }

    }

}
