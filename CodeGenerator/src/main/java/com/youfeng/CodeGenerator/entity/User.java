package com.youfeng.CodeGenerator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author -侑枫
 * @since 2023-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.ASSIGN_ID)
    private String userid;

    private String username;

    private String password;

    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "updatetime", fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

}
