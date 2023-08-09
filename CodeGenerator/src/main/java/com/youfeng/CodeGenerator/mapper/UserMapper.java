package com.youfeng.CodeGenerator.mapper;

import com.youfeng.CodeGenerator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author -侑枫
 * @since 2023-05-21
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 添加结果 >0 表示插入成功
     */
    int insert(User user);
}
