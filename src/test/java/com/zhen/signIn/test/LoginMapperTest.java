package com.zhen.signIn.test;

import com.zhen.signIn.dao.LoginMapper;
import com.zhen.signIn.pojo.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author LiJiaZhen
 * @date 2021/9/26 21:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class LoginMapperTest{
    @Autowired
    private LoginMapper loginMapper;

    public void testCountByExample() {
    }
    @Test
    public void testDeleteByExample() {
//        删除全部
        loginMapper.deleteByExample(null);
    }

    public void testDeleteByPrimaryKey() {
    }
    @Test
    public void testInsert() {
        for(int i = 0;i<3;i++){
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format_data = simpleDateFormat.format(date);
            Login login = new Login(uuid+"",uuid + "" + i,date);
            loginMapper.insert(login);
        }
    }

    public void testInsertSelective() {
    }

    public void testSelectByExample() {
    }

    public void testSelectByPrimaryKey() {
    }

    public void testUpdateByExampleSelective() {
    }

    public void testUpdateByExample() {
    }

    public void testUpdateByPrimaryKeySelective() {
    }

    public void testUpdateByPrimaryKey() {
    }
}