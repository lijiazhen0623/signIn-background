package com.zhen.signIn.pojo;

import java.util.Date;

public class Login {
    private String sid;

    private String sname;

    private Date loginTime;

    public Login() {
    }

    public Login(String sid, String sname, Date loginTime) {
        this.sid = sid;
        this.sname = sname;
        this.loginTime = loginTime;
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
}