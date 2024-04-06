package com.example.kazanm1.models;

public class WellLayerItem {
    private long from;
    private long to;
    private long rock_id;
    private String rock_name;

    public WellLayerItem(long from, long to, long rock_id, String rock_name) {
        this.from = from;
        this.to = to;
        this.rock_id = rock_id;
        this.rock_name = rock_name;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public long getRock_id() {
        return rock_id;
    }

    public void setRock_id(long rock_id) {
        this.rock_id = rock_id;
    }

    public String getRock_name() {
        return rock_name;
    }

    public void setRock_name(String rock_name) {
        this.rock_name = rock_name;
    }
    public String getData(){
        return rock_name+"\nFrom:"+from+"\nTo:"+to;
    }
}
