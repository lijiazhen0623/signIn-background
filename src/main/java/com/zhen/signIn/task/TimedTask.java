package com.zhen.signIn.task;

import com.zhen.signIn.dao.HistoryMapper;
import com.zhen.signIn.pojo.Login;
import com.zhen.signIn.pojo.Logout;
import com.zhen.signIn.pojo.User;
import com.zhen.signIn.service.DailyService;
import com.zhen.signIn.service.LoginService;
import com.zhen.signIn.service.LogoutService;
import com.zhen.signIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:55
 */
@Component
public class TimedTask {
    @Autowired
    private DailyService dailyService;
    @Autowired
    private UserService userService;
    @Autowired
    private LogoutService logoutService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private HistoryMapper historyMapper;
    /**
     * 每天凌晨 12点 执行一次，重置今天的签到和签退数据，并清除历史表中签到时间为空的数据
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteTodayData(){
        dailyService.resetTodayLogoutTime();
        dailyService.resetTodayLoginTime();
        historyMapper.clearLoginIsNull();
    }

    /**
     * 每个星期的周日晚上11点重置全员总时间以及清空历史表
     */
    @Scheduled(cron = "0 0 23 ? * SUN")
    public void resetAllTimeAndHistory(){
        dailyService.resetAllTime();
        dailyService.clearHistory();
    }

    /**
     * 每天11点，17点，22点 半 自动签退
     */
    @Scheduled(cron = "0 30 11,17,22 * * ?")
    public void autoLogout(){
        for (User onlineUser : userService.getOnlineUsers()) {
            String sid = onlineUser.getSid();
            //设置签退时间
            Date date = new Date();
            Logout logout = new Logout(sid, null, date);
            logoutService.setLogoutTimeBySid(logout);
            //改变用户状态为离线状态
            User user = new User(sid, null, null, "0");
            userService.resetStatusBySid(user);
            //获取此次上班时常
            Login loginBySid = loginService.getLoginBySid(sid);
            Logout logoutBySid = logoutService.getLogoutBySid(sid);
            //更新总时长
            long l = logoutBySid.getLogoutTime().getTime() - loginBySid.getLoginTime().getTime() + Long.parseLong(onlineUser.getTotalTime() == null ? "0" : onlineUser.getTotalTime());
            User user1 = new User(sid, null, l + "", null);
            userService.updateTotalTime(user1);
        }

    }

}
