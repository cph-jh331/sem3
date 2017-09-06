/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import entity.Person;
import entity.PersonFacade;

import java.util.List;
import javax.persistence.Persistence;
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
import javax.ws.rs.core.Response;
import utility.JSONConverter;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    private PersonFacade pf;

    public PersonResource()
    {
        pf = new PersonFacade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("jpaPU"));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id)
    {

        Person p = pf.getPerson(id);
        return JSONConverter.getJSONFromPerson(p);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        List<Person> pList = pf.getPersons();
        return JSONConverter.getJSONFromPerson(pList);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content)
    {
        Person person = JSONConverter.getPersonFromJson(content);
        return Response.status(Response.Status.CREATED)
                .entity(JSONConverter.getJSONFromPerson(pf.addPerson(person)))
                .build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deletePerson(@PathParam("id") int id)
    {
        return JSONConverter.getJSONFromPerson(pf.deletePerson(id));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(@PathParam("id") int id, String body)
    {
        Person p = JSONConverter.getPersonFromJson(body);
        return JSONConverter.getJSONFromPerson(pf.editPerson(p));
    }

}
