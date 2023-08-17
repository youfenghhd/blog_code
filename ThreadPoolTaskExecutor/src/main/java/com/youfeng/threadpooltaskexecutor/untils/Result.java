package com.youfeng.threadpooltaskexecutor.untils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author -无心
 * @date 2023/2/16 16:05:42
 * 表现层和前端传输数据协议
 * 统一返回结果的类
 */
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String GLOBAL_ERR = "全局异常";
    public static final Integer SUCCESS = 20000;
    public static final Integer ERROR = 20001;

    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;


    private Boolean success;
    private Integer status;
    private String message;

    private Result() {

    }

    private Map<String, Object> data = new HashMap<>();

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public static Result ok() {
        Result result = new Result();
        result.setStatus(SUCCESS);
        result.setSuccess(true);
        result.setMessage("成功");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setStatus(ERROR);
        result.setMessage("失败");
        return result;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setStatus(code);
        return this;
    }


}
