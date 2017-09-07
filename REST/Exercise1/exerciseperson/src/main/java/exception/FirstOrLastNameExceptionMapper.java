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
public class FirstOrLastNameExceptionMapper implements ExceptionMapper<FirstOrLastNameException> {

    @Context
    private ServletContext context;

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(FirstOrLastNameException exception)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(exception, 400, isDebug);
        err.setDescription("First name or last name invalid");
        err.setMessage("First Name or Last Name is missing");

        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }

}
