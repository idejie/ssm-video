package com.grey.ssm.school.model;

import java.util.Date;

public class Assitant {
    private int id;
    private int assitant_id;
    private int assitee_id;
    private Date time;
    private String content;

    public Assitant() {
    }

    public Assitant(int id, int assitant_id, int assitee_id, Date time, String content) {

        this.id = id;
        this.assitant_id = assitant_id;
        this.assitee_id = assitee_id;
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssitant_id() {
        return assitant_id;
    }

    public void setAssitant_id(int assitant_id) {
        this.assitant_id = assitant_id;
    }

    public int getAssitee_id() {
        return assitee_id;
    }

    public void setAssitee_id(int assitee_id) {
        this.assitee_id = assitee_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
