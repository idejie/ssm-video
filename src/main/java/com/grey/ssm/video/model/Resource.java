package com.grey.ssm.video.model;

public class Resource {
    private int r_id;
    private int v_id;
    private String pic_url;
    private String subtitle;
    private String style;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String toJSON() {
        return "{" +
                "\"r_id\":\'" + r_id +"\',"+
                "\"v_id\":\'" + v_id +"\',"+
                "\"pic_url\":\'" + pic_url +"\',"+
                "\"subtitle\":\'" + subtitle +"\',"+
                "\"style\":\'" + style +"\',"+
                "}";
    }
}
