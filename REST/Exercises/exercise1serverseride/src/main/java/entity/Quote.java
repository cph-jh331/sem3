package entity;

import com.google.gson.annotations.Expose;

public class Quote {

    private int id;
    @Expose
    private String quote;

    public Quote()
    {
    }

    public Quote(int id, String quote)
    {
        this.id = id;
        this.quote = quote;

    }

    public String getQuote()
    {
        return quote;
    }

    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

}
