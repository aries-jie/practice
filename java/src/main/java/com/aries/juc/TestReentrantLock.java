package com.aries.juc;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
//        Runnable task = () -> {
//            try {
//                lock.lock();
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("aaa");
//            }  finally {
//                lock.unlock();
//            }
//        };
//        Thread thread1 = new Thread(task);
//        Thread thread2 = new Thread(task);
//        Thread thread3 = new Thread(task);
//        thread1.start();
//        thread2.start();
//        thread3.start();

    }
}
