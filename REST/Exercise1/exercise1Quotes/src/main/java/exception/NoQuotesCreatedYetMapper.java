package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoQuotesCreatedYetMapper implements ExceptionMapper<NoQuotesCreatedYetException> {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(NoQuotesCreatedYetException exception)
    {
        ErrorMessage em = new ErrorMessage(exception.getMessage(), 204);
        return Response.status(Response.Status.NO_CONTENT)
                .entity(gson.toJson(em))
                .build();
    }

}
