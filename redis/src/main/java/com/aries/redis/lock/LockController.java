package com.aries.redis.lock;

import com.aries.redis.common.Result;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式锁测试
 */
@RestController
public class LockController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/lock/getName")
    public String getName() {
        RBucket<String> name = redissonClient.getBucket("name");
        return name.get();
    }

    @GetMapping("/lock/setName")
    public String setName() {
        RBucket<String> name = redissonClient.getBucket("name");
        name.set("xiaojie");
        return "success";
    }

    @GetMapping("/lock/getLock")
    public Result getLock() {
        RLock lock = redissonClient.getLock("lock");
        try {
            // 拿锁且不设置锁超时时间，具备 Watch Dog 自动续期机制
            // 手动给锁设置过期时间，不具备 Watch Dog 自动续期机制
            if (lock.tryLock()) {
                System.out.println("获取锁");
                Thread.sleep(10);
                lock.unlock();
                System.out.println("释放锁");
            } else {
                throw new RuntimeException("error");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Result.success();
    }
}