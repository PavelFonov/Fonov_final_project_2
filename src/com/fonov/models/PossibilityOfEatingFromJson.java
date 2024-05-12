package com.fonov.models;

public class PossibilityOfEatingFromJson {


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setPrecent(int precent) {
        this.precent = precent;
    }

    public int getPrecent() {
        return precent;
    }

    protected String from;
    protected String to;
    protected int precent;

}
