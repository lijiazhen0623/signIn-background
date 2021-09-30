package com.zhen.signIn.test;

import com.zhen.signIn.dao.LoginMapper;
import com.zhen.signIn.dao.LogoutMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 19:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DailyServiceTest {
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    LogoutMapper logoutMapper;
    @Test
    public void resetTodayLoginTime() {
        loginMapper.resetTimeToNull();
    }

    @Test
    public void resetTodayLogoutTime() {
        logoutMapper.resetTimeToNull();
    }
}