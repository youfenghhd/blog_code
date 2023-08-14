package com.youfeng.blog;

import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

/**
 * @author -侑枫
 * @date 2023/8/11 19:58:53
 */
public class SleepAndWait {
    static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws Exception {
        sleep();
        Wait();
        lockOfSleep();
        lockOfWait();
        getStatus();
    }

    private static void sleep() {
        try {
            System.out.println("Sleep开始");
            stopWatch.start();
            Thread.sleep(2000);
            stopWatch.stop();
            System.out.println("Sleep结束");
            System.out.println(stopWatch.getTotalTimeSeconds() + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait() {
        System.out.println("Wait开始");
        stopWatch.start();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(2000);
                    stopWatch.stop();
                    System.out.println("Wait结束");
                    System.out.println(stopWatch.getTotalTimeSeconds() + "秒");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 在另一个线程中，当某些条件满足时，唤醒等待的线程
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(1000);
                    // 或 lock.notifyAll()，唤醒所有等待线程
                    lock.notify();
                    System.out.println("线程被唤醒");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private static void lockOfSleep() throws Exception {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("新线程获取到锁：" + LocalDateTime.now());
                try {
                    Thread.sleep(2000);
                    System.out.println("新线程获释放锁：" + LocalDateTime.now());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 等新线程先获得锁
        Thread.sleep(200);
        System.out.println("主线程尝试获取锁：" + LocalDateTime.now());
        // 在新线程休眠之后，尝试获取锁
        synchronized (lock) {
            System.out.println("主线程获取到锁：" + LocalDateTime.now());
        }
    }

    private static void lockOfWait() throws Exception {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("新线程获取到锁：" + LocalDateTime.now());
                try {
                    lock.wait(2000);
                    System.out.println("新线程获释放锁：" + LocalDateTime.now());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(200);
        System.out.println("主线程尝试获取锁：" + LocalDateTime.now());
        synchronized (lock) {
            System.out.println("主线程获取到锁：" + LocalDateTime.now());
        }
    }

    private static void getStatus() throws Exception {
        Object lock = new Object();
        Thread wait = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        wait.start();

        Thread waitWithParam = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitWithParam.start();

        Thread sleep = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sleep.start();

        Thread.sleep(500);
        System.out.println("wait() 方法后状态为：" + wait.getState());
        System.out.println("wait(millis) 方法后状态为：" + waitWithParam.getState());
        System.out.println("sleep(millis) 之后进入状态：" + sleep.getState());
    }
}
