package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ParamException;

@Provider
public class PathParamExceptionMapper implements ExceptionMapper<ParamException> {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(ParamException exception)
    {
    ErrorMessage em = new ErrorMessage("Service does not exist", 404);
        return Response.status(404)
                .entity(gson.toJson(em))
                .build();
    }

}
