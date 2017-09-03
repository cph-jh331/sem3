/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1.serverside;

import entity.Quote;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bloch
 */
@Path("/quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GenericResource {

    @Context
    private UriInfo context;

    private static Random rand = new Random();
    //private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static Map<Integer, Quote> quotes = new HashMap() {
        {
            Quote quote = new Quote(1, "Friends are kisses blown to us by angels");
            put(1, quote);
            quote = new Quote(2, "Do not take life too seriously. You will never get out of it alive");
            put(2, quote);
            quote = new Quote(3, "Behind every great man, is a woman rolling her eyes");
            put(3, quote);
        }
    };

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource()
    {
    }

    @GET
    @Path("/{id}")
    public String getQuote(@PathParam("id") int id)
    {
        return gson.toJson(quotes.get(id));
    }

    @GET
    @Path("/random")
    public String getRandomQuote()
    {
        int id = rand.nextInt(quotes.size()) + 1;
        return gson.toJson(quotes.get(id));
    }

    @GET
    @Path("/all")

    public String getAllQuotes()
    {
        List<Quote> list = new ArrayList<>(quotes.values());
        return gson.toJson(list);
    }

    @POST
    @Path("/{id}")
    public String addQuote(String body)
    {
        Quote quote = gson.fromJson(body, Quote.class);
        quote.setId(quotes.size() + 1);
        quotes.put(quote.getId(), quote);
        //gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(quote);
        //gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        return json;
    }

    @PUT
    @Path("/{id}")
    public String updateQuote(@PathParam("id") int id, String body)
    {
        System.out.println(body);
        Quote newquote = gson.fromJson(body, Quote.class);
        newquote.setId(id);
        quotes.put(newquote.getId(), newquote);
        //gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(newquote);
        //gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        return json;
    }

    @DELETE
    @Path("{id}")
    public String deleteQuote(@PathParam("id") int id)
    {
        Quote quote = quotes.remove(id);
        return gson.toJson(quote);
    }

}
