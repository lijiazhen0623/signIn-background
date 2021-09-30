package com.zhen.signIn.service.serviceImpl;

import com.zhen.signIn.dao.UserMapper;
import com.zhen.signIn.pojo.User;
import com.zhen.signIn.pojo.UserExample;
import com.zhen.signIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 21:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getOnlineUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andStatusEqualTo("1");
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public void resetStatusBySid(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateTotalTime(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserBySid(String sid) {
        User user = userMapper.selectByPrimaryKey(sid);
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public void selectiveUpdates(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
