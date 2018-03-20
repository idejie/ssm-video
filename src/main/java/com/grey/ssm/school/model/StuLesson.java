package com.grey.ssm.school.model;

public class StuLesson {
    private int id;
    private int stu_id;
    private int l_id;
    private String grade;

    public StuLesson(int id, int stu_id, int l_id, String grade) {
        this.id = id;
        this.stu_id = stu_id;
        this.l_id = l_id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
