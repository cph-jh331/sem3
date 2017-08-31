/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Quote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bloch
 */
@WebServlet(name = "QuoteServlet", urlPatterns =
{
    "/QuoteServlet"
})
public class QuoteServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Quote> quotes;

    private static List<Quote> makeArray()
    {

        if (quotes == null)
        {
            System.out.println("is null");
            quotes = new ArrayList<>();
            quotes.add(new Quote(1, "This be a joke", "Bob's sayings"));
            quotes.add(new Quote(2, "This be anoter joke", "Bob's sayings"));
            quotes.add(new Quote(3, "This is a joke", "Bob's sayings"));
            quotes.add(new Quote(4, "This was a joke", "Bob's sayings"));
        }
        return quotes;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            quotes = makeArray();
            Random rand = new Random();
            int randomNumber = rand.nextInt(4);
            Quote quote = quotes.get(randomNumber);

            out.println(gson.toJson(quote));
            System.out.println(gson.toJson(quote));
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
