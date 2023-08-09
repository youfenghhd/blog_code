package com.youfeng.CodeGenerator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
public class File implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "fileid", type = IdType.ASSIGN_ID)
    private String fileid;

    private String filename;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private String type;

    private String collection;

    private Boolean logicdel;


}
