/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem3.exercise1quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Quote;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bloch
 */
@Path("quote")
public class QuoteResource {

    private static Map<Integer, Quote> quotes = new HashMap();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Random rand = new Random();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteResource
     */
    public QuoteResource()
    {
        if (quotes.isEmpty())
        {
            quotes.put(1, new Quote("Friends are kisses blown to us by angels", 1));
            quotes.put(2, new Quote("Do not take life too seriously. You will never get out of it alive", 2));
            quotes.put(3, new Quote("Behind every great man, is a woman rolling her eyes", 3));
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id)
    {
        return gson.toJson(quotes.get(id));
    }

    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote()
    {
        int id = rand.nextInt(quotes.size()) + 1;
        return gson.toJson(quotes.get(id));
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll()
    {
        return (gson.toJson(quotes.values()));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addQuote(String body)
    {
        Quote quote = gson.fromJson(body, Quote.class);
        quote.setId(quotes.size() + 1);
        quotes.put(quote.getId(), quote);
        return gson.toJson(quote);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateQuote(@PathParam("id") int id, String body)
    {
        Quote quote = gson.fromJson(body, Quote.class);
        quotes.put(id, quote);
        return gson.toJson(quotes.get(id));
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteQuote(@PathParam("id") int id)
    {
        return gson.toJson(quotes.remove(id));
    }
}
