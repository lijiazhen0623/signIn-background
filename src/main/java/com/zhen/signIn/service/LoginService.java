package com.zhen.signIn.service;

import com.zhen.signIn.pojo.Login;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:17
 */
public interface LoginService {
    /**
     * 获取所有签到记录
     * @return
     */
    public List<Login> getAllLogin();

    /**
     * 通过学号获取签到记录
     * @return
     */
    public Login getLoginBySid(String sid);

    /**
     * 添加新用户的签到数据
     * @param login
     */
    public void addNewLogin(Login login);

    /**
     * 用户签到
     * @param login
     */
    public void login(Login login);

}
