package com.grey.ssm.school.model;

import java.util.Date;

public class Lesson {
    private int id;
    private String lesson;
    private int length;
    private int finished;
    private int t_id;
    private String college;
    private String subject;
    private Date time;

    public Lesson() {
    }

    public Lesson(int id, String lesson, int length, int finished, int t_id, String college, String subject, Date time) {
        this.id = id;
        this.lesson = lesson;
        this.length = length;
        this.finished = finished;
        this.t_id = t_id;
        this.college = college;
        this.subject = subject;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
