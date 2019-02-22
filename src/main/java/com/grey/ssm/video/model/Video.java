package com.grey.ssm.video.model;

public class Video {
    private int v_id;
    private int u_id;
    private int is_full;
    private String location;
    private String title;
    private String descr;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getIs_full() {
        return is_full;
    }

    public void setIs_full(int is_full) {
        this.is_full = is_full;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toJSON() {
        return "{" +
                "\"v_id\":\'" + v_id +"\',"+
                "\"u_id\":\'" + u_id +"\',"+
                "\"is_full\":\'" + is_full +"\',"+
                "\"location\":\'" + location +"\',"+
                "\"title\":\'" + title +"\',"+
                "\"descr\":\'" + descr+"\',"+
                "}";
    }
}
