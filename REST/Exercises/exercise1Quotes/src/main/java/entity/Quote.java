package entity;

public class Quote {

    private String quote;
    private int id;

    public Quote()
    {
    }

    public Quote(String quote, int id)
    {
        this.quote = quote;
        this.id = id;
    }

    public String getQuote()
    {
        return quote;
    }

    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
