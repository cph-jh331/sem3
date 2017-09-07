/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import deploy.DeploymentConfiguration;
import entity.Person;
import entity.PersonFacade;
import exception.CannotDeletePersonException;
import exception.CannotEditException;
import exception.FirstOrLastNameException;
import exception.IdIsNotIntegerException;
import exception.PersonNotFoundException;
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
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") String id)
    {
        int anid;
        try
        {
            anid = Integer.parseInt(id);
        } catch (NumberFormatException e)
        {
            throw new IdIsNotIntegerException();
        }
        Person p = pf.getPerson(anid);
        if (p == null)
        {
            throw new PersonNotFoundException();
        }

        return Response.status(Response.Status.OK)
                .entity(JSONConverter.getJSONFromPerson(p))
                .build();
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
        if (person.getfName().equals("") || person.getlName().equals(""))
        {
            throw new FirstOrLastNameException();
        }

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
        Person person = pf.getPerson(id);
        if (person == null)
        {
            throw new CannotDeletePersonException();
        }
        return JSONConverter.getJSONFromPerson(pf.deletePerson(id));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(@PathParam("id") int id, String body)
    {
        Person p = JSONConverter.getPersonFromJson(body);
        if (p.getfName().equals("") || p.getlName().equals(""))
        {
            throw new FirstOrLastNameException();
        }

        if (pf.getPerson(p.getId().intValue()) == null)
        {
            throw new CannotEditException();
        }
        return JSONConverter.getJSONFromPerson(pf.editPerson(p));
    }

}
