package com.aries.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ZookeeperLockService {

    @Autowired
    private CuratorFramework curatorFramework;

    public void performTaskWithLock() {
        String lockPath = "/my-lock"; // 锁的路径，可以根据业务定义

        // 创建分布式锁
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, lockPath);

        try {
            // 尝试加锁，最多等待 10 秒
            if (lock.acquire(10, TimeUnit.SECONDS)) {
                // 成功获取锁，执行业务逻辑
                System.out.println("Successfully acquired the lock. Performing the task...");

                // 模拟业务逻辑
                Thread.sleep(5000);

                System.out.println("Task completed.");

            } else {
                // 未能获取锁，可能是其他地方正在执行相同的任务
                System.out.println("Failed to acquire the lock. Another task may be in progress.");
            }

        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();

        } finally {
            // 释放锁
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
