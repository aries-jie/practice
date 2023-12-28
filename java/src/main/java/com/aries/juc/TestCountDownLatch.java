package com.aries.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable task = () -> {
            try {
                Thread.sleep(5000L);
                System.out.println("aaa");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
            }
        };
        Runnable task2 = () -> {
            try {
                Thread.sleep(10000L);
                System.out.println("bbb");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
            }
        };
        Runnable task3 = () -> {
            try {
                Thread.sleep(15000L);
                System.out.println("ccc");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        thread1.start();
        thread2.start();
        thread3.start();

        while (thread1.isAlive()) {
            System.out.println("thread1 active");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            countDownLatch.await();
            System.out.println("ddd");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
