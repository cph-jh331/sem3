package exception;

public class NoQuotesCreatedYetException extends RuntimeException {

    public NoQuotesCreatedYetException()
    {
    }

    public NoQuotesCreatedYetException(String msg)
    {
        super(msg);
    }
}
