package com.youfeng.CodeGenerator.service;

import com.youfeng.CodeGenerator.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author -侑枫
 * @since 2023-05-21
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 添加结果
     */
    String addUser(User user);
}
