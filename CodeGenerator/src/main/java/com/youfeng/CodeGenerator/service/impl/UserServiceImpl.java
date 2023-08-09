package com.youfeng.CodeGenerator.service.impl;

import com.youfeng.CodeGenerator.entity.User;
import com.youfeng.CodeGenerator.mapper.UserMapper;
import com.youfeng.CodeGenerator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author -侑枫
 * @since 2023-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper mapper;

    @Override
    public String addUser(User user) {
        return mapper.insert(user) > 0 ? "添加成功" : "添加失败";
    }
}
