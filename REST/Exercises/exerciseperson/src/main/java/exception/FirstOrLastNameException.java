package exception;

public class FirstOrLastNameException extends RuntimeException {

    public FirstOrLastNameException()
    {
    }

    public FirstOrLastNameException(String msg)
    {
        super(msg);
    }
}
