package com.zhen.signIn.service.serviceImpl;

import com.zhen.signIn.dao.HistoryMapper;
import com.zhen.signIn.dao.LoginMapper;
import com.zhen.signIn.dao.LogoutMapper;
import com.zhen.signIn.dao.UserMapper;
import com.zhen.signIn.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:43
 */
@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private LogoutMapper logoutMapper;
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void resetTodayLoginTime(){
        loginMapper.resetTimeToNull();
    }

    @Override
    public void resetTodayLogoutTime() {
        logoutMapper.resetTimeToNull();
    }

    @Override
    public void clearHistory() {
        historyMapper.deleteByExample(null);
    }

    @Override
    public void resetAllTime() {
        userMapper.resetAllTimeToNull();
    }

}
