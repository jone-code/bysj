package com.jone.cache.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } finally {
            return result;
        }
    }

    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            return true;
        } finally {
            return result;
        }
    }

    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


    public void hmSet(String key, Object hahKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hahKey, value);
    }

    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    public void lPush(String key,Object value){
        ListOperations<String,Object> list = redisTemplate.opsForList();
        list.rightPush(key,value);
    }

    public List<Object> lRange(String key,long l,long l1){
        return redisTemplate.opsForList().range(key,l,l1);
    }

    public void addSet(String key,Object value){
        SetOperations<String,Object> sets = redisTemplate.opsForSet();
        sets.add(key,value);
    }

    public Set<Object> getSetMembers(String key){
        return redisTemplate.opsForSet().members(key);
    }


    public void zAdd(String key,Object value,double source){
        ZSetOperations<String,Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,source);
    }

    public Set<Object> rangeBySource(String key,double source,double source1){
        ZSetOperations<String,Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key,source,source1);
    }

    public void selectDB(int i){
        redisTemplate.execute((RedisCallback) c->c.dbSize());
    }
}
