package com.grey.ssm.school.model;

import java.util.Date;

public class Coment {
    private int id;
    private int cha_id;
    private Date time;
    private String content;

    public Coment() {
    }

    public Coment(int id, int cha_id, Date time, String content) {
        this.id = id;
        this.cha_id = cha_id;
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCha_id() {
        return cha_id;
    }

    public void setCha_id(int cha_id) {
        this.cha_id = cha_id;
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
