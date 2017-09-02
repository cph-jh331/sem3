package test;

import javax.persistence.Persistence;

public class createData {

    public static void main(String[] args)
    {
        Persistence.generateSchema("myPU", null);
    }

}
