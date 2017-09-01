/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bloch
 */
@WebServlet(name = "ProxyServlet", urlPatterns =
{
    "/ProxyServlet"
})
public class ProxyServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/json;charset=UTF-8");
        String customHeader = request.getHeader("x-custom-header");
        if (customHeader.equals("givfstuff"))
        {
            readAndSend(request, response);
        }

    }

    protected void readAndSend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String strIso = gson.fromJson(request.getReader(), String.class);
        int index = strIso.indexOf('s');
        StringBuilder sb = new StringBuilder(strIso);
        sb.deleteCharAt(index);
        strIso = sb.toString();

        URL url = new URL(strIso);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();

        try (PrintWriter out = response.getWriter())
        {
            out.println(jsonStr);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
