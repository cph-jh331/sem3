package exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException()
    {
    }

    public PersonNotFoundException(String msg)
    {
        super(msg);
    }
}
