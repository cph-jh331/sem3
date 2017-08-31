/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import entity.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bloch
 */
@WebServlet(name = "PersonServlet", urlPatterns =
{
    "/PersonServlet"
})
public class PersonServlet extends HttpServlet {
    
    private static List<Person> persons;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private List<Person> createPersons()
    {
        List<Person> prs = new ArrayList<>();
        prs.add(new Person("Bobby", "Jensen", "44885577"));
        prs.add(new Person("Christian", "Hansen", "21885577"));
        prs.add(new Person("Knud", "Knudsen", "45885573"));
        prs.add(new Person("Øyvind", "Haraldsen", "30885539"));
        
        return prs;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        response.setContentType("application/json;charset=UTF-8");
        String customHeader = request.getHeader("x-custom-header");
        if (customHeader.equals("givfstuff"))
        {
            getPersons(response);
        }
        if (customHeader.equals("addstuff"))
        {
            addPerson(request, response);
        }
        
    }
    
    protected void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        Person person = gson.fromJson(request.getReader(), Person.class);
        persons.add(person);
        getPersons(response);
    }
    
    protected void getPersons(HttpServletResponse response) throws IOException
    {
        if (persons == null)
        {
            persons = createPersons();
        }
        try (PrintWriter out = response.getWriter())
        {
            out.println(gson.toJson(persons));
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
}
