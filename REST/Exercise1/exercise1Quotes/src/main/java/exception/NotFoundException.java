package exception;

/**
 *
 * @author bloch
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException()
    {
    }

    public NotFoundException(String msg)
    {
        super(msg);
    }
}
