package com.zhen.signIn.service;

import com.zhen.signIn.pojo.History;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 21:44
 */
public interface HistoryService {
    /**
     * 获取所有的历史记录
     * @return
     */
    public List<History> getAllHistory();

    /**
     * 清空历史表中签到时间为空的表
     */
    public void clearLoginIsNull();
}
