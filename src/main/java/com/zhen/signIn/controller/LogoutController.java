package com.zhen.signIn.controller;

import com.zhen.signIn.pojo.Login;
import com.zhen.signIn.pojo.Logout;
import com.zhen.signIn.pojo.Message;
import com.zhen.signIn.pojo.User;
import com.zhen.signIn.service.LoginService;
import com.zhen.signIn.service.LogoutService;
import com.zhen.signIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:14
 */
@Controller
public class LogoutController {
    @Autowired
    private LogoutService logoutService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    /**
     * 签退接口
     * @param logout
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Message logout(Logout logout){
        //设置签到时间
        logout.setLogoutTime(new Date());
        logoutService.logout(logout);
        //改变用户状态为离线状态
        User user = new User(logout.getSid(), null, null, "0");
        userService.resetStatusBySid(user);
        //获取此次上班时常
        Login loginBySid = loginService.getLoginBySid(logout.getSid());

        //更新总时长
        long l = logout.getLogoutTime().getTime() - loginBySid.getLoginTime().getTime() + Long.parseLong(userService.getUserBySid(logout.getSid()).getTotalTime() == null ? "0" : userService.getUserBySid(logout.getSid()).getTotalTime());
        User user1 = new User(logout.getSid(), null, l + "", null);
        userService.updateTotalTime(user1);
        return Message.success("签退成功");
    }
}
