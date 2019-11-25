package com.jerry.springboot_redis_crud.util;


import lombok.Setter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

@Setter
public class RedisUtil {
    private RedisTemplate<String,Object> redisTemplate;

    public boolean set(String key,Object value)
    {
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void del(String... key)
    {
        if(key!=null&&key.length>0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
        }
        }
    }
    public Object get(String key)
    {
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

}
