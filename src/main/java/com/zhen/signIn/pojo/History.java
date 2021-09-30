package com.zhen.signIn.pojo;

import java.util.Date;

public class History {
    private Integer number;

    private String sid;

    private String sname;

    private Date loginTime;

    private Date logoutTime;

    public History() {
    }

    public History(Integer number, String sid, String sname, Date loginTime, Date logoutTime) {
        this.number = number;
        this.sid = sid;
        this.sname = sname;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}