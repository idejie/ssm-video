package com.grey.ssm.school.model;

public class Admin {
    private int id;
    private String username;
    private String passwd;
    private String email;

    public Admin() {
    }

    public Admin(int id, String username, String passwd, String email) {

        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
