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
        HOW DO YOU TEST THE PERSON ONE?
     */
    public Person getPersonFromJson(String js)
    {
        return gson.fromJson(js, Person.class);
    }

    public String getJSONFromPerson(Person p)
    {
        return gson.toJson(p);
    }

    public String getJSONFromPerson(List<Person> persons)
    {
        return gson.toJson(persons);
    }
}
