package com.grey.ssm.video.model;

public class User {
    private int u_id;
    private String username;
    private String password;
    private int permisson;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int u_id, String username, String password, int permisson) {
        this.u_id = u_id;
        this.username = username;
        this.password = password;
        this.permisson = permisson;
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

    public int getPermisson() {
        return permisson;
    }

    public void setPermisson(int permisson) {
        this.permisson = permisson;
    }

    public String toJSON() {
        return "{" +
                "\"u_id\":\'" + u_id +"\',"+
                "\"username\":\'" + username + "\'," +
                "\"password\":\'" + password + "\'" +
                "\"permisson\":\'" + permisson + "\'" +
                "}";
    }
}
