package com.zhen.signIn.controller;

import com.zhen.signIn.pojo.Login;
import com.zhen.signIn.pojo.Logout;
import com.zhen.signIn.pojo.Message;
import com.zhen.signIn.pojo.User;
import com.zhen.signIn.service.LoginService;
import com.zhen.signIn.service.LogoutService;
import com.zhen.signIn.service.UserService;
import com.zhen.signIn.util.GetIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 17:24
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LogoutService logoutService;
    /**
     * 验证ip是否正确
     * @param request
     * @return
     */
    @RequestMapping(value = "/Ip",method = RequestMethod.GET)
    @ResponseBody
    public Message verificationIp(HttpServletRequest request){
        Properties properties = new Properties();
        //class.getClassLoader().getResourceAsStream(String name)
        // 默认从classpath中找文件(文件放在resources目录下)，
        // name不能带"/"，否则会抛空指针。采用相对路径, "/"就相当于当前进程的根目录，即项目根目录；
        try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("IP.properties")){
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ip = GetIp.getIp(request);
        if(ip.equals(properties.getProperty("IP"))){
            return Message.success("验证成功！！");
        }
        return Message.fail("IP不对");
    }

    /**
     * 签到接口
     * @param login
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Message login(Login login){
        //设置签到时间
        login.setLoginTime(new Date());
        //首先判断该用户是否是新用户
        User user = userService.getUserBySid(login.getSid());
        if(user !=null){
            //签到
            loginService.login(login);
            //改变用户状态
            userService.selectiveUpdates(new User(login.getSid(),null,null,"1"));
        }else {
            //如果为空就添加该用户到数据库并进行签到
            userService.addUser(new User(login.getSid(), login.getSname(), null, "1"));
            loginService.addNewLogin(login);
            logoutService.addNewLogout(new Logout(login.getSid(),login.getSname(),null));
        }
        return Message.success("签到成功");
    }
}
