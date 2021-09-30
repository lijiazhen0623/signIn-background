package com.zhen.signIn.service;

import com.zhen.signIn.pojo.User;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 21:58
 */
public interface UserService {
    /**
     * 获取所有在线的用户
     *
     * @return
     */
    public List<User> getOnlineUsers();

    /**
     * 通过学号重新设置用户状态
     * @param user
     */
    public void resetStatusBySid(User user);

    /**
     * 更新总时长
     * @param user
     */
    public void updateTotalTime(User user);

    /**
     * 通过学号查找用户
     * @param sid
     * @return
     */
    public User getUserBySid(String sid);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser();

    /**
     * 有选择的更新用户信息
     * @param user
     */
    public void selectiveUpdates(User user);
}
