package com.heima.schedule.test;


import com.heima.common.redis.CacheService;
import com.heima.schedule.ScheduleApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private CacheService cacheService;

    @Test
    public void testList(){

        //在list的左边添加元素
//        cacheService.lLeftPush("list_001","hello_world");

        //在list的右边获取元素并删除
        String s = cacheService.lRightPop("list_001");
        System.out.println(s);

    }

    @Test
    public void testZset(){
        // 添加数据到Zset中 有分值
//        cacheService.zAdd("zset_key_001","hello zset 001",1000);
//        cacheService.zAdd("zset_key_001","hello zset 002",888);
//        cacheService.zAdd("zset_key_001","hello zset 003",777);
//        cacheService.zAdd("zset_key_001","hello zset 004",666);


        //按照分值进行查询
        Set<String> zset_key_001 = cacheService.zRangeByScore("zset_key_001", 0, 888);
        System.out.println(zset_key_001);
    }

}
