package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Pet;
import facade.EntityFacade;
import java.util.List;
import javax.persistence.Persistence;

public class testing {
    
    public static void main(String[] args)
    {
        EntityFacade ef = new EntityFacade(Persistence.createEntityManagerFactory("pu1"));
        List<Pet> pList = ef.getAllPets();
        for (Pet pet : pList)
        {
            System.out.println(pet);
        }
        
        JsonObject jo = new JsonObject();
        jo.addProperty("petCount", pList.size());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        System.out.println(gson.toJson(jo));
        System.out.println(pList.get(0).getOwnerId().getFirstName());
    }

}
