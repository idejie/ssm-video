package com.grey.ssm.school.model;

import java.util.Date;

public class Chapter {
    private int id;
    private int l_id;
    private String cha_name;
    private Date start;
    private Date end;
    private String preview;
    private String review;

    public Chapter() {
    }

    public Chapter(int id, int l_id, String cha_name, Date start, Date end, String preview, String review) {
        this.id = id;
        this.l_id = l_id;
        this.cha_name = cha_name;
        this.start = start;
        this.end = end;
        this.preview = preview;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getCha_name() {
        return cha_name;
    }

    public void setCha_name(String cha_name) {
        this.cha_name = cha_name;
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

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
