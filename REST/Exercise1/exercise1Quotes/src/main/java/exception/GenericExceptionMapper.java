package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<RuntimeException> {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(RuntimeException exception)
    {
        ErrorMessage em = new ErrorMessage("Internal server Error, we are very sorry for the inconvenience", 500);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(gson.toJson(em))
                .build();
    }

}
