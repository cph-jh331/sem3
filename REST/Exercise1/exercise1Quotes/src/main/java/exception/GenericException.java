package exception;

public class GenericException extends RuntimeException {

    public GenericException()
    {
    }

    public GenericException(String msg)
    {
        super(msg);
    }
}
