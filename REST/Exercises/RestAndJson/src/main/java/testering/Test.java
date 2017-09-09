package testering;

import entity.Generator;

public class Test {

    public static void main(String[] args)
    {
        Generator gen = new Generator();
        gen.generate(10, 1000);
        System.out.println(gen.generate(10, 1000));
    }

}
