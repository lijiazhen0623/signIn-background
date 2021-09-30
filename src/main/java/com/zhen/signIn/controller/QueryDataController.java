package com.zhen.signIn.controller;

import com.zhen.signIn.pojo.*;
import com.zhen.signIn.service.HistoryService;
import com.zhen.signIn.service.LoginService;
import com.zhen.signIn.service.LogoutService;
import com.zhen.signIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/29 20:08
 */
@Controller
public class QueryDataController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private LogoutService logoutService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private UserService userService;

    /**
     * 查询所有历史记录的接口
     * @return
     */
    @RequestMapping(value = "/queryHistory")
    @ResponseBody
    public Message queryHistory(){
        List<History> allHistory = historyService.getAllHistory();
        return Message.success("查询成功").add("allHistory",allHistory);
    }

    /**
     * 查询所有签到记录
     * @return
     */
    @RequestMapping(value = "/queryAllLogin")
    @ResponseBody
    public Message queryAllLogin(){
        List<Login> allLogin = loginService.getAllLogin();
        return Message.success("查询成功").add("allLogin",allLogin);
    }

    @RequestMapping(value = "/queryAllLogout")
    @ResponseBody
    public Message queryAllLogout(){
        List<Logout> allLogout = logoutService.getAllLogout();
        return Message.success("查询成功").add("allLogout",allLogout);
    }

    /**
     * 查询所有用户接口
     * @return
     */
    @RequestMapping(value = "/queryAllUser")
    @ResponseBody
    public Message queryAllUser(){
        List<User> allUser = userService.getAllUser();
        return Message.success("查询成功").add("allUser",allUser);
    }
}
