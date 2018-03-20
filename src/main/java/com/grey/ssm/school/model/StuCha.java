package com.grey.ssm.school.model;

public class StuCha {
    private int id;
    private int cha_id;
    private int stu_id;
    private String content;

    public StuCha() {
    }

    public StuCha(int id, int cha_id, int stu_id, String content) {
        this.id = id;
        this.cha_id = cha_id;
        this.stu_id = stu_id;
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

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
