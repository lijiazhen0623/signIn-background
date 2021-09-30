package com.zhen.signIn.service.serviceImpl;

import com.zhen.signIn.dao.LogoutMapper;
import com.zhen.signIn.pojo.Logout;
import com.zhen.signIn.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:20
 */
@Service
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private LogoutMapper logoutMapper;

    @Override
    public List<Logout> getAllLogout() {
        List<Logout> logouts = logoutMapper.selectByExample(null);
        return logouts;
    }

    @Override
    public Logout getLogoutBySid(String sid) {
        Logout logout = logoutMapper.selectByPrimaryKey(sid);
        return logout;
    }

    @Override
    public boolean setLogoutTimeBySid(Logout logout) {
        int i = logoutMapper.updateByPrimaryKeySelective(logout);
        return i>0;
    }

    @Override
    public void addNewLogout(Logout logout) {
        logoutMapper.insert(logout);
    }

    @Override
    public void logout(Logout logout) {
        logoutMapper.updateByPrimaryKey(logout);
    }
}
