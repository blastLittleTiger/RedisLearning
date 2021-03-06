package wjc.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Author: 王俊超
 * Date: 2017-11-28 20:42
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class RBucketDemo {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        redisson.getKeys().flushall();
        RBucket<AnyObject> bucket = redisson.getBucket("anyObject");
        bucket.set(new AnyObject(1));
        AnyObject obj = bucket.get();
        System.out.println(mapper.writeValueAsString(obj));


        bucket.set(new AnyObject(3));
        System.out.println(mapper.writeValueAsString(bucket.get()));

        bucket.compareAndSet(new AnyObject(3), new AnyObject(5));
        System.out.println(mapper.writeValueAsString(bucket.get()));

        obj = bucket.getAndSet(new AnyObject(6));
        System.out.println(mapper.writeValueAsString(obj));
        System.out.println(mapper.writeValueAsString(bucket.get()));

        redisson.shutdown();
    }
}
