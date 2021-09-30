package com.zhen.signIn.service.serviceImpl;

import com.zhen.signIn.dao.LoginMapper;
import com.zhen.signIn.pojo.Login;
import com.zhen.signIn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:17
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> getAllLogin() {
        List<Login> logins = loginMapper.selectByExample(null);
        return logins;
    }

    @Override
    public Login getLoginBySid(String sid) {
        Login login = loginMapper.selectByPrimaryKey(sid);
        return login;
    }

    @Override
    public void addNewLogin(Login login) {
        loginMapper.insert(login);
    }

    @Override
    public void login(Login login) {
        loginMapper.updateByPrimaryKeySelective(login);
    }
}
