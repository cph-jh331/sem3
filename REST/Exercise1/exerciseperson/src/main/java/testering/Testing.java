package testering;

import Entity.Person;
import Entity.PersonFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Testing {
    
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        PersonFacade pf = new PersonFacade();
        pf.addEntityManagerFactory(emf);
        Person bob = new Person("Test", "test", "11111111");
        System.out.println("adding person");
        System.out.println(pf.addPerson(bob));
        System.out.println("getting person with id 5");
        System.out.println(pf.getPerson(5));
        System.out.println("getting all persons");
        List<Person> pList = pf.getPersons();
        for (Person person : pList)
        {
            System.out.println(person);
        }
        Person testP = pf.getPerson(5);
        testP.setfName("JegErEnTest");
        System.out.println("editing person with id 5");
        System.out.println(pf.editPerson(testP));
        System.out.println("deleting person with id 5");
        System.out.println(pf.deletePerson(5));
        System.out.println("getting all persons");
        pList = pf.getPersons();
        for (Person person : pList)
        {
            System.out.println(person);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(bob));
        String json = "{\n"
                + "  \"id\": 5,\n"
                + "  \"fName\": \"Test\",\n"
                + "  \"lName\": \"test\",\n"
                + "  \"phone\": \"11111111\"\n"
                + "}";
        System.out.println(gson.fromJson(json, Person.class));
        
    }
    
}
