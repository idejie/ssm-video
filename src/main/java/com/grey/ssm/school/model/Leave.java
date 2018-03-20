package com.grey.ssm.school.model;

import java.util.Date;

public class Leave {
    private int id;
    private int sl_id;
    private Date time;
    private Date start;
    private Date end;
    private int status;
    private String content;

    public Leave(int id, int sl_id, Date time, Date start, Date end, int status, String content) {
        this.id = id;
        this.sl_id = sl_id;
        this.time = time;
        this.start = start;
        this.end = end;
        this.status = status;
        this.content = content;
    }

    public Leave() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSl_id() {
        return sl_id;
    }

    public void setSl_id(int sl_id) {
        this.sl_id = sl_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
