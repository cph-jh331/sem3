/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facade.EntityFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utility.JSONHelper;

/**
 * REST Web Service
 *
 * @author Bloch
 */
@Path("pet")
public class PetResource {

    @Context
    private UriInfo context;
    private EntityFacade ef;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public PetResource()
    {
        this.ef = new EntityFacade(Persistence.createEntityManagerFactory("pu1"));
    }

    @GET
    @Path("petcount")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetCount()
    {
        JsonObject jo = new JsonObject();
        jo.addProperty("petCount", ef.getAllPets().size());
        return Response
                .status(200)
                .entity(gson.toJson(jo))
                .build();
    }

    @GET
    @Path("allpets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPets()
    {
        return Response
                .status(200)
                .entity(JSONHelper.getJsonArray("allPets", ef.getAllPets()))
                .build();
    }

    @GET
    @Path("alivepets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLiving()
    {
        return Response
                .status(200)
                .entity(JSONHelper.getJsonArray("alivePets", ef.getAllLivingPets()))
                .build();
    }

}
