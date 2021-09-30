package com.zhen.signIn.service;

/**
 * @author LiJiaZhen
 * @date 2021/9/27 21:43
 */
public interface DailyService {
    /**
     * 重置今天所有用户的签到时间为null
     */
    public void resetTodayLoginTime();

    /**
     * 重置今天所有用户的签退时间为null
     */
    public void resetTodayLogoutTime();

    /**
     * 清除历史记录
     */
    public void clearHistory();

    /**
     * 重置全员的总时间
     */
    public void resetAllTime();
}
