package com.youfeng.CodeGenerator.controller;


import com.youfeng.CodeGenerator.entity.User;
import com.youfeng.CodeGenerator.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author -侑枫
 * @since 2023-05-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping("/add")
    public String add() {
        User user = new User();
        user.setUsername("-wuxin");
        user.setPassword("456");
        return userService.addUser(user);
    }

    @PostMapping("/insert")
    public String insert() {
        User user = new User();
        user.setUsername("-snow");
        user.setPassword("456");
        return userService.save(user) ? "添加成功" : "添加失败";
    }

}

