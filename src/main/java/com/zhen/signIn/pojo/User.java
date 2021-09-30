package com.zhen.signIn.pojo;

public class User {
    private String sid;

    private String sname;

    private String totalTime;
    /**
     * 1 为在线 0 为离线
     */
    private String status;

    public User() {
    }

    public User(String sid, String sname, String totalTime, String status) {
        this.sid = sid;
        this.sname = sname;
        this.totalTime = totalTime;
        this.status = status;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}