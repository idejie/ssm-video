package com.grey.ssm.school.model;

public class Teacher {
    private int id;
    private String username;
    private String passwd;
    private int qq;
    private String email;
    private String college;
    private String subject;

    public Teacher() {
    }

    public Teacher(int id, String username, String passwd, int qq, String email, String college, String subject) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.qq = qq;
        this.email = email;
        this.college = college;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
