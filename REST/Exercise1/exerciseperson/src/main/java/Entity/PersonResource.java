/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    // SHOULD THESE BE STATIC?
    private EntityManagerFactory emf;
    private PersonFacade pf;
    private JSONConverter convert = new JSONConverter();

    public PersonResource()
    {
        emf = Persistence.createEntityManagerFactory("jpaPU");
        pf = new PersonFacade(emf);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id)
    {
        Person p = pf.getPerson(id);
        return convert.getJSONFromPerson(p);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        List<Person> pList = pf.getPersons();
        return convert.getJSONFromPerson(pList);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content)
    {
        Person person = convert.getPersonFromJson(content);
        return convert.getJSONFromPerson(pf.addPerson(person));

    }
}
