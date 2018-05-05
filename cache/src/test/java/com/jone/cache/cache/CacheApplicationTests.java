package com.jone.cache.cache;

import com.jone.cache.cache.pojo.User;
import com.jone.cache.cache.service.RedisUtil;
import com.jone.cache.cache.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	private static final String key = "jone";//这里的key值可以自己修改
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private UserService userService;


	@Test
	public void findUser(){
		String str = key.concat("1");
		boolean haskey = redisUtil.exists(str);
		if (haskey){
			Object object = redisUtil.get(str);
			logger.info("从缓存中拿到的值--->"+object.toString());
		}else{
			logger.info("从db中获取--->");
			User user = userService.selectById("1");
			//然后放到缓存中
			redisUtil.set(str,user,10L, TimeUnit.SECONDS);
			logger.info("数据缓存到redis");
		}
	}


	@Test
	public void delete(){
		String str = key.concat("1");
		boolean haskey = redisUtil.exists(str);
		if(haskey){
			Object object = redisUtil.get(str);
			redisUtil.remove(str);
			logger.info("从缓存中删除"+str);
		}else{
			logger.info("缓存中没有数据"+str);
		}
	}



	@Test
	public void contextLoads() {


	}

}
