package com.babbobastardo.model;

public abstract class Participant {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    public Participant(Participant participant) {
        this.name = participant.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //L: sono formalmente contrario alla sintassi di questo codice
    //J: <3 8==D
}
