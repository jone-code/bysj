package com.jone.cache.cache.mapper;

import com.jone.cache.cache.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //////////////////////////
    List<User> selectAll();
}