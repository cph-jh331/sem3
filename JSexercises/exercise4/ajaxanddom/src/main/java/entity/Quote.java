package entity;

public class Quote {

    private int id;
    private String joke;
    private String reference;

    public Quote(int id, String joke, String reference)
    {
        this.id = id;
        this.joke = joke;
        this.reference = reference;
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

    /**
     * @return the joke
     */
    public String getJoke()
    {
        return joke;
    }

    /**
     * @param joke the joke to set
     */
    public void setJoke(String joke)
    {
        this.joke = joke;
    }

    /**
     * @return the reference
     */
    public String getReference()
    {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference)
    {
        this.reference = reference;
    }

}
