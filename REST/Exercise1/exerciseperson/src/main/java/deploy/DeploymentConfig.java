package deploy;

import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DeploymentConfig implements ServletContextListener {

    public static String PU_NAME = "jpuU";

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        Map<String, String> env = System.getenv();

        if (env.keySet().contains("DODeployment"))
        {
            PU_NAME = "serverPU";
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }

}
