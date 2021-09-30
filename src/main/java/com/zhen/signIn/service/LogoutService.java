package com.zhen.signIn.service;

import com.zhen.signIn.pojo.Logout;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:19
 */
public interface LogoutService {
    /**
     * 获取所有签退记录
     * @return
     */
    public List<Logout> getAllLogout();

    /**
     * 通过学号获取签退记录
     * @return
     */
    public Logout getLogoutBySid(String sid);

    /**
     * 通过学号来设置签退
     * @param logout
     * @return
     */
    public boolean setLogoutTimeBySid(Logout logout);

    /**
     * 添加新用户
     * @param logout
     */
    public void addNewLogout(Logout logout);

    /**
     * 签退
     * @param logout
     */
    public void logout(Logout logout);
}
