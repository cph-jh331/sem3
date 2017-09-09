package rest;

import entity.Generator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("data")
public class GeneratorResource {

    @Context
    private UriInfo context;
    private static Generator gen = new Generator();

    public GeneratorResource()
    {
    }

    @GET
    @Path("{size}/{startId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("size") int size, @PathParam("startId") int startId)
    {
        return Response
                .status(Response.Status.CREATED)
                .entity(gen.generate(size, startId))
                .build();
    }

}
