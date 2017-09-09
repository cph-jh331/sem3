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
public class CannotEditExceptionMapper implements ExceptionMapper<CannotEditException> {

    @Context
    ServletContext context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(CannotEditException exception)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(exception, 404, isDebug);
        err.setDescription("Persons not found...");
        err.setMessage("Cannot edit. Person with provided id does not exist");

        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
}
