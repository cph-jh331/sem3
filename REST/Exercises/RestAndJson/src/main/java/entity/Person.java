package entity;

public class Person {

    private int id;
    private String fName;
    private String lName;
    private int age;

    public Person()
    {
    }

    public Person(int id, String fName, String lName, int age)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + '}';
    }

}
