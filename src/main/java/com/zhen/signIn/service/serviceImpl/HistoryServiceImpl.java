package com.zhen.signIn.service.serviceImpl;

import com.zhen.signIn.dao.HistoryMapper;
import com.zhen.signIn.pojo.History;
import com.zhen.signIn.pojo.HistoryExample;
import com.zhen.signIn.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 21:44
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<History> getAllHistory() {
        List<History> histories = historyMapper.selectByExample(null);
        return histories;
    }

    @Override
    public void clearLoginIsNull() {
        historyMapper.clearLoginIsNull();
    }

    @Override
    public List<History> getHistoryBySid(String sid) {
        HistoryExample historyExample = new HistoryExample();
        HistoryExample.Criteria criteria = historyExample.createCriteria();
        criteria.andSidEqualTo(sid);
        List<History> histories = historyMapper.selectByExample(historyExample);
        return histories;
    }
}
