package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Pet;
import java.util.List;

public class JSONHelper {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String getJsonArray(String nameOfBase, List<Pet> listOfPets)
    {
        JsonObject baseJsonObject = new JsonObject();
        JsonArray jArrayPets = new JsonArray();

        for (Pet pet : listOfPets)
        {
            JsonObject jPet = new JsonObject();
            jPet.addProperty("id", pet.getId());
            jPet.addProperty("name", pet.getName());
            jPet.addProperty("birth", "" + pet.getBirth());
            jPet.addProperty("species", pet.getSpecies());
            jPet.addProperty("first_name", pet.getOwnerId().getFirstName());
            jPet.addProperty("last_name", pet.getOwnerId().getLastName());
            jArrayPets.add(jPet);
        }

        //remember this, else gson will throw a runtime error.
        baseJsonObject.add(nameOfBase, jArrayPets);
        return gson.toJson(baseJsonObject);
    }

}
