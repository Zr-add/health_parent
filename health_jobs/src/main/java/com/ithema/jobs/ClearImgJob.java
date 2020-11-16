package com.ithema.jobs;

import com.ithema.constant.RedisConstant;
import com.ithema.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class ClearImgJob {

    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        Set<String> sdiff = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if(sdiff != null){
            for (String s : sdiff) {
                QiniuUtils.deleteFileFromQiniu(s);
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES,s);
                System.out.println(s);
            }
        }
    }

}
