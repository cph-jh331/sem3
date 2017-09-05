package utility;

import Entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

public class JSONConverter {

    /*
    public static Person getPersonFromJson(String js){..}  
    public static String getJSONFromPerson(Person p) {..}  
    public static String getJSONFromPerson(List<Person> persons) {..} 
     */
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /*
        WHY IS THE SHIT BELOW STATIC?
        They are static, so you do not need to new the JSONConverter in
        the person resource.
        HOW DO YOU TEST STATIC METHODS IN JUNIT?
     */
    public static Person getPersonFromJson(String js)
    {
        return gson.fromJson(js, Person.class);
    }

    public static String getJSONFromPerson(Person p)
    {
        return gson.toJson(p);
    }

    public static String getJSONFromPerson(List<Person> persons)
    {
        return gson.toJson(persons);
    }
}
