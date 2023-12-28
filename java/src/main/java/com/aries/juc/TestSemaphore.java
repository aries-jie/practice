package com.aries.juc;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                Thread.sleep(5000L);
                System.out.println("aaa");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
