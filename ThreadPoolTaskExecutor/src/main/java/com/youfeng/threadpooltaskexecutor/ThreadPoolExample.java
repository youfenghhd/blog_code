package com.youfeng.threadpooltaskexecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author -侑枫
 * @date 2023/8/13 22:35:19
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        /**
         * 创建线程池
         * @Param CorePoolSize：核心线程2
         * @Param MaxPoolSize：非核心线程4
         * @Param QueueCapacity：任务队列容量10
         * @Param KeepAliveSeconds：线程空闲时间10秒
         * @Param RejectedExecutionHandler：拒绝策略 CallerRunsPolicy（调用者执行策略）
         * @Param WaitForTasksToCompleteOnShutdown：等待线程任务执行完毕再关闭线程池
         * @Param AwaitTerminationSeconds：线程池等待线程任务执行时间
         */
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(2);
        threadPool.setMaxPoolSize(4);
        threadPool.setQueueCapacity(10);
        threadPool.setKeepAliveSeconds(10);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(30);
        // 线程池取名
        threadPool.setThreadNamePrefix("MyThread-");
        // 初始化线程池
        threadPool.initialize();

        // 提交任务到线程池
        for (int i = 1; i <= 15; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
                try {
                    // 模拟任务执行时间
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}
