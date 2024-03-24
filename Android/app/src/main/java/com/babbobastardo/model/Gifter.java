package com.babbobastardo.model;

public class Gifter extends Participant {
    private String email;
    private Gifted gifted;

    public Gifter(String name, String email) {
        super(name);
        this.email = email;
        gifted = null;
    }

    public Gifter(String name, String email, Gifted gifted)
    {
        super(name);
        this.email = email;
        this.gifted = gifted;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Gifted getGifted()
    {
        return gifted;
    }

    public void setGifted(Gifted gifted)
    {
        this.gifted = gifted;
    }
}

