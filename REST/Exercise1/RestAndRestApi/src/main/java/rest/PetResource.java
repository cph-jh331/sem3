package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.PetCount;
import facade.EntityFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pet")
public class PetResource {

    @Context
    private UriInfo context;
    private EntityFacade ef;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of PetResource
     */
    public PetResource()
    {
        this.ef = new EntityFacade(Persistence.createEntityManagerFactory("sem3_RestAndRestApi_war_1.0PU"));
    }

    /**
     * Retrieves representation of an instance of rest.PetResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson()
    {
        PetCount pc = new PetCount(ef.getAllPets().size());

        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(pc))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content)
    {
    }
}
