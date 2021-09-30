package com.zhen.signIn.dao;

import com.zhen.signIn.pojo.Logout;
import com.zhen.signIn.pojo.LogoutExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogoutMapper {
    long countByExample(LogoutExample example);

    int deleteByExample(LogoutExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Logout record);

    int insertSelective(Logout record);

    List<Logout> selectByExample(LogoutExample example);

    Logout selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Logout record, @Param("example") LogoutExample example);

    int updateByExample(@Param("record") Logout record, @Param("example") LogoutExample example);

    int updateByPrimaryKeySelective(Logout record);

    int updateByPrimaryKey(Logout record);

    void resetTimeToNull();
}