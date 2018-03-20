package com.grey.ssm.school.model;

public class Order {
    private int id;
    private int act_id;
    private int g_id;
    private int p_id;
    private int status;

    public Order() {
    }

    public Order(int id, int act_id, int g_id, int p_id, int status) {

        this.id = id;
        this.act_id = act_id;
        this.g_id = g_id;
        this.p_id = p_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
