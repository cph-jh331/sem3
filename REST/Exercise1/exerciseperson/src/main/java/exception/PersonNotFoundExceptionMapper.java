package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private ServletContext context;

    @Override
    public Response toResponse(PersonNotFoundException exception)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(exception, 404, isDebug);
        err.setDescription("Tried to call...");
        err.setMessage("No person with provided id found");
        
        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }

}
