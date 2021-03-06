package sem3.exercise1quotes;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources)
    {
        resources.add(exception.GenericExceptionMapper.class);
        resources.add(exception.NoQuotesCreatedYetMapper.class);
        resources.add(exception.PathParamExceptionMapper.class);
        resources.add(exception.QuoteNotFoundMapper.class);
        resources.add(sem3.exercise1quotes.QuoteResource.class);
    }

}
