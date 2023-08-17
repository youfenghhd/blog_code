package com.youfeng.threadpooltaskexecutor.service.impl;

import com.youfeng.threadpooltaskexecutor.service.TaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author -侑枫
 * @date 2023/8/13 22:54:36
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Override
    @Async("customThreadPool")
    public void processTask(int taskId) {
        System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
        try {
            // 模拟任务执行时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
