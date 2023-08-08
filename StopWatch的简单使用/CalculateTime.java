package com.youfeng.blog;

import org.springframework.util.StopWatch;

/**
 * @author -侑枫
 * 请注意，本文件的java代码需在 Spring 全家桶环境下使用或在项目中导入 Hutool/Apache 包
 *
 * @date 2023/8/7 18:52:01
 */
public class CalculateTime {
    public static void main(String[] args) throws Exception {
        useCurrentTimeMillis();
        useStopWatchOne();
        useStopWatchTwo();
        useStopWatchThree();
    }

    private static void useStopWatchOne() throws Exception {
        StopWatch stopWatchOne = new StopWatch();
        StopWatch stopWatchTwo = new StopWatch();
        stopWatchOne.start("外层代码块");
        stopWatchTwo.start("内层代码块a");
        Thread.sleep(1000);
        stopWatchTwo.stop();
        System.out.println(stopWatchTwo.getLastTaskName() + "执行时间：" + stopWatchTwo.getLastTaskTimeMillis());
        stopWatchTwo.start("内层代码块b");
        Thread.sleep(2000);
        stopWatchTwo.stop();
        System.out.println(stopWatchTwo.getLastTaskName() + "执行时间：" + stopWatchTwo.getLastTaskTimeMillis());
        Thread.sleep(4000);
        stopWatchOne.stop();
        System.out.println(stopWatchOne.getLastTaskName() + "执行时间：" + stopWatchOne.getTotalTimeMillis());
    }

    private static void useStopWatchTwo() throws Exception {
        StopWatch stopWatchOne = new StopWatch();
        stopWatchOne.start("代码块a");
        Thread.sleep(1000);
        stopWatchOne.stop();
        System.out.println(stopWatchOne.getLastTaskName() + "执行时间：" + stopWatchOne.getLastTaskTimeMillis());
        stopWatchOne.start("代码块b");
        Thread.sleep(2000);
        stopWatchOne.stop();
        System.out.println(stopWatchOne.getLastTaskName() + "执行时间：" + stopWatchOne.getLastTaskTimeMillis());
        stopWatchOne.start("代码块c");
        Thread.sleep(4000);
        stopWatchOne.stop();
        System.out.println(stopWatchOne.getLastTaskName() + "执行时间：" + stopWatchOne.getLastTaskTimeMillis());
        System.out.println("代码总执行时间：" + stopWatchOne.getTotalTimeMillis());

    }

    private static void useStopWatchThree() throws Exception {
        StopWatch stopWatchOne = new StopWatch();
        stopWatchOne.start("代码块a");
        Thread.sleep(1000);
        stopWatchOne.stop();
        stopWatchOne.start("代码块b");
        Thread.sleep(2000);
        stopWatchOne.stop();
        stopWatchOne.start("代码块c");
        Thread.sleep(4000);
        stopWatchOne.stop();
        System.out.println(stopWatchOne.prettyPrint());
    }

    private static void useCurrentTimeMillis() throws Exception {
        long startTimeOne = System.currentTimeMillis();
        long startTimeTwo = System.currentTimeMillis();
        Thread.sleep(1000);
        long stopTimeTwo = System.currentTimeMillis();
        System.out.println("内层代码块a执行时间：" + (stopTimeTwo - startTimeTwo));
        Thread.sleep(2000);
        long startTimeThree = System.currentTimeMillis();
        Thread.sleep(3000);
        long stopTimeThree = System.currentTimeMillis();
        System.out.println("内层代码块b执行时间：" + (stopTimeThree - startTimeThree));
        Thread.sleep(4000);
        long stopTimeOne = System.currentTimeMillis();
        System.out.println("外层代码块执行时间：" + (stopTimeOne - startTimeOne));
    }
}
