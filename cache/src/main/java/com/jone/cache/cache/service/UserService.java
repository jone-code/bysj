package com.jone.cache.cache.service;

import com.jone.cache.cache.mapper.UserMapper;
import com.jone.cache.cache.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.selectAll();
    }

    public User selectById(String cid){
        return userMapper.selectByPrimaryKey(cid);
    }
}
