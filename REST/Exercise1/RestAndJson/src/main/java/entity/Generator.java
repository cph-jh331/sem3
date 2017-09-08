package entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private static String[] firstNames =
    {
        "Bob", "Jens", "Frans", "Knud", "Ole", "Kjartan", "Olga", "Dagmar"
    };
    private static String[] lastNames =
    {
        "Hansen", "Jensen", "Fransen", "Knudsen", "Olsen", "Christiansen", "Halvorsen", "Olgasen"
    };

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static Random rand = new Random();

    public Generator()
    {
    }

    public String generate(int size, int startId)
    {
        List<Person> persons = new ArrayList<>();
        int startNumber = startId;

        for (int i = 0; i < size; i++)
        {
            persons.add(new Person(startNumber, firstNames[rand.nextInt(firstNames.length)],
                    lastNames[rand.nextInt(lastNames.length)], rand.nextInt(71 - 17) + 17));
            startNumber++;
        }

        return gson.toJson(persons);

    }

}
