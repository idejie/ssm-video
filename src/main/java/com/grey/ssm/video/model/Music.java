package com.grey.ssm.video.model;

public class Music {
    private int m_id;
    private int v_id;
    private String url;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Music() {
    }

    public Music(int m_id, int v_id, String url) {
        this.m_id = m_id;
        this.v_id = v_id;
        this.url = url;
    }
}
