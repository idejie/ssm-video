package com.grey.ssm.school.model;

public class Activity {
    private int id;
    private String actname;
    private String addition;
    private double price;
    private int u_id;

    public Activity() {
    }

    public Activity(int id, String actname, String addition, double price, int u_id) {
        this.id = id;
        this.actname = actname;
        this.addition = addition;
        this.price = price;
        this.u_id = u_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
