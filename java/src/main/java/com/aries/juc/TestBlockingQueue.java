package com.aries.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueue {

    static class Producer implements Runnable {
        protected BlockingQueue<String> queue = null;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    // 等待直到可以put
//                    queue.put(i + "");
                    // 当队列不够用时抛异常
//                    queue.add(i + "");
                    // 成功返回true，失败返回false
                    queue.offer(i + "");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        protected BlockingQueue<String> queue = null;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                Thread.sleep(4000);
                for (int i = 0; i < 10; i++) {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

//        Thread.sleep(4000);
    }
}
