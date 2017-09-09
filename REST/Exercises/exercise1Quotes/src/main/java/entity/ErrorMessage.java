package entity;

public class ErrorMessage {

    private int errorCode;
    private String errorMessage;

    public ErrorMessage()
    {
    }

    public ErrorMessage(String errorMessage, int errorCode)
    {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode()
    {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

}
