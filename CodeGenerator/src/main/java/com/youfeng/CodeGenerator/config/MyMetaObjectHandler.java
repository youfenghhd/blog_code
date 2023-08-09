package com.youfeng.CodeGenerator.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author -侑枫
 * @date 2023/5/21 15:54:45
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", simp.format(new Date()), metaObject);
        this.setFieldValByName("updateTime", simp.format(new Date()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", simp.format(new Date()), metaObject);
    }
}
