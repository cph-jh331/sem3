/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import entity.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bloch
 */
public class JSONConverterTest {

    public JSONConverterTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of getPersonFromJson method, of class JSONConverter.
     */
    /*
    @Test
    public void testGetPersonFromJson()
    {
        //hvad fanden??
        System.out.println("getPersonFromJson");
        String js = "{\n"
                + "  \"id\": 1,\n"
                + "  \"fName\": \"Bob\",\n"
                + "  \"lName\": \"Hansen\",\n"
                + "  \"phone\": \"44332211\"\n"
                + "}";
        Person expResult = new Person("Bob", "Hansen", "44332211");
        expResult.setId(1L);
        System.out.println(expResult);
        Person result = JSONConverter.getPersonFromJson(js);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    */

    /**
     * Test of getJSONFromPerson method, of class JSONConverter.
     */
    @Test
    public void testGetJSONFromPerson_Person()
    {
        System.out.println("getJSONFromPerson");
        Person p = new Person("Bob", "Hansen", "44332211");
        p.setId(1L);
        String expResult = "{\n"
                + "  \"id\": 1,\n"
                + "  \"fName\": \"Bob\",\n"
                + "  \"lName\": \"Hansen\",\n"
                + "  \"phone\": \"44332211\"\n"
                + "}";
        String result = JSONConverter.getJSONFromPerson(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getJSONFromPerson method, of class JSONConverter.
     */
    @Test
    public void testGetJSONFromPerson_List()
    {
        System.out.println("getJSONFromPerson");
        List<Person> persons = new ArrayList<>();
        long count = 1;
        Person p = new Person("Bob", "Hansen", "44332211");
        p.setId(count);
        persons.add(p);
        count++;
        p = new Person("James", "Jamesen", "22334455");
        p.setId(count);
        persons.add(p);
        count++;
        p = new Person("Frans", "Fransen", "44332211");
        p.setId(count);
        persons.add(p);
        count++;
        p = new Person("Egil", "Egilsen", "55332211");
        p.setId(count);
        persons.add(p);
        count++;
        String expResult = "[\n"
                + "  {\n"
                + "    \"id\": 1,\n"
                + "    \"fName\": \"Bob\",\n"
                + "    \"lName\": \"Hansen\",\n"
                + "    \"phone\": \"44332211\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": 2,\n"
                + "    \"fName\": \"James\",\n"
                + "    \"lName\": \"Jamesen\",\n"
                + "    \"phone\": \"22334455\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": 3,\n"
                + "    \"fName\": \"Frans\",\n"
                + "    \"lName\": \"Fransen\",\n"
                + "    \"phone\": \"44332211\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": 4,\n"
                + "    \"fName\": \"Egil\",\n"
                + "    \"lName\": \"Egilsen\",\n"
                + "    \"phone\": \"55332211\"\n"
                + "  }\n"
                + "]";
        String result = JSONConverter.getJSONFromPerson(persons);
        assertEquals(expResult, result);
    }

}
