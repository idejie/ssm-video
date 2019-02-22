package com.grey.ssm.video.model;

public class User {
    private int u_id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int u_id, String username, String password) {
        this.u_id = u_id;
        this.username = username;
        this.password = password;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSON() {
        return "{" +
                "\"u_id\":\'" + u_id +"\',"+
                "\"username\":\'" + username + "\'," +
                "\"password\":\'" + password + "\'" +
                "}";
    }
}
