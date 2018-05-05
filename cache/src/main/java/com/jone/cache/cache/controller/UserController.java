package com.jone.cache.cache.controller;

import com.jone.cache.cache.pojo.User;
import com.jone.cache.cache.service.RedisUtil;
import com.jone.cache.cache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserController(){
        System.out.println("========================");
    }
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public String getAllUser() {
        List<User> list = userService.getAll();
        System.out.println(list.size());
        return list.size()+"";
    }

    private static final String key = "jone";//这里的key值可以自己修改


    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(){
        String str = key.concat("1");
        boolean haskey = redisUtil.exists(str);
        if (haskey){
            Object object = redisUtil.get(str);
            logger.info("从缓存中拿到的值--->"+object.toString());
        }else{
            logger.info("从db中获取--->");
            User user = userService.selectById("1");
            //然后放到缓存中
            redisUtil.set(str,user,10L, TimeUnit.MINUTES);
            logger.info("数据缓存到redis");
        }
        return "1";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        String str = key.concat("1");
        boolean haskey = redisUtil.exists(str);
        if(haskey){
            Object object = redisUtil.get(str);
            redisUtil.remove(str);
            logger.info("从缓存中删除"+str);
        }else{
            logger.info("缓存中没有数据"+str);
        }
        return "1";
    }


}
