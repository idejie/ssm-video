package com.grey.ssm.school.model;

public class Student {
    private int id;
    private String stu_name;
    private String passwd;
    private int grade;
    private int age;
    private int qq;
    private String tele;
    private String email;
    private String college;
    private String subject;

    public Student() {
    }

    public Student(int id, String stu_name, String passwd, int grade,
                   int age, int qq, String tele, String email,
                   String college, String subject) {
        this.id = id;
        this.stu_name = stu_name;
        this.passwd = passwd;
        this.grade = grade;
        this.age = age;
        this.qq = qq;
        this.tele = tele;
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

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
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
