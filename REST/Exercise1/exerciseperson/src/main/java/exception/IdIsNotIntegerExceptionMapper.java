
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ErrorMessage;
import exception.IdIsNotIntegerException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class IdIsNotIntegerExceptionMapper implements ExceptionMapper<IdIsNotIntegerException> {

    @Context
    private ServletContext context;

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(IdIsNotIntegerException exception)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(exception, 404, isDebug);
        err.setDescription("Id was invalid");
        err.setMessage("Id was not an integer");

        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
