package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundMapper implements ExceptionMapper<NotFoundException> {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(NotFoundException exception)
    {
        ErrorMessage em = new ErrorMessage(exception.getMessage(), 404);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(gson.toJson(em))
                .build();
    }

}
