package schemacontrol;

import javax.persistence.Persistence;

public class SchemaBuilder {

    public static void main(String[] args)
    {
        Persistence.generateSchema("jpaPU", null);
    }

}
