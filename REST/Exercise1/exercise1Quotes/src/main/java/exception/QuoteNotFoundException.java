package exception;

public class QuoteNotFoundException extends RuntimeException {

    /**
     * Creates a new instance of <code>QuoteNotFoundException</code> without
     * detail message.
     */
    public QuoteNotFoundException()
    {
    }

    /**
     * Constructs an instance of <code>QuoteNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QuoteNotFoundException(String msg)
    {
        super(msg);
    }
}
