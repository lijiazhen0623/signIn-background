package com.zhen.signIn.pojo;

import java.util.Date;

public class Logout {
    private String sid;

    private String sname;

    private Date logoutTime;

    public Logout() {
    }

    public Logout(String sid, String sname, Date logoutTime) {
        this.sid = sid;
        this.sname = sname;
        this.logoutTime = logoutTime;
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

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}