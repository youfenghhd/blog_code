package com.youfeng.threadpooltaskexecutor.controller;

import com.youfeng.threadpooltaskexecutor.service.TaskService;
import com.youfeng.threadpooltaskexecutor.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author -侑枫
 * @date 2023/8/13 22:59:40
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/submit")
    public Result submitTasks() {
        for (int i = 1; i <= 15; i++) {
            taskService.processTask(i);
        }
        return Result.ok();
    }
}
