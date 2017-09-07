/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Bloch
 */
@Provider
public class CannotDeletePersonExceptionMapper implements ExceptionMapper<CannotDeletePersonException> {
    
    @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(CannotDeletePersonException exception)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        
        ErrorMessage err = new ErrorMessage(exception, 404, isDebug);
        err.setDescription("Person not found...");
        err.setMessage("Could not delete. No person with provided id exists");
        
        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
