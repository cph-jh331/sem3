/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest1tomcat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jsonmappers.Person;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<Integer, Person> persons = new HashMap();
    private static int nextId = 0;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource()
    {
        if (persons.isEmpty())
        {
            persons.put(nextId, new Person(nextId, "Fisk", "Fisksen", "44332211"));
            nextId++;
            persons.put(nextId, new Person(nextId, "Bobby", "Bobbysen", "44332211"));
            nextId++;
        }
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        return gson.toJson(persons.values());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id)
    {

        return gson.toJson(persons.get(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(String content)
    {
        Person p = gson.fromJson(content, Person.class);
        p.setId(nextId);
        persons.put(nextId, p);
        nextId++;
        return gson.toJson(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(String body)
    {
        Person person = gson.fromJson(body, Person.class);
        persons.put(person.getId(), person);
        return gson.toJson(person);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("id") int id)
    {
        return gson.toJson(persons.remove(id));

    }
}
