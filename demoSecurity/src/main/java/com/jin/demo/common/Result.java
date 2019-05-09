package com.jin.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;

/**
 * @author Jin
 * @Title: Result
 * @ProjectName court-new
 * @Description: TODO
 * @date 2019/4/28/02817:30
 */
public class Result extends HashMap<String, Object> {
//    private String message;
//    private int code;
//    private Object data;
//    private String path;
//    private int count = 0;

    private Result() {
        put("code",200);
        put("msg","操作成功");
    }

    public Result(int code, String msg) {
        put("code",code);
        put("msg",msg);
    }

    private Result(Object data, String msg, int code, int count) {
        put("code",code);
        put("msg",msg);
        put("data",data);
        put("count",count);
    }

    /**
     * 成功时候的调用
     *
     * @return
     */
    public static Result success(Object data) {
        return Result.success(data, "操作成功", 0);
    }

    public static Result success() {
        return (Result) Result.success(null, "操作成功", 0);
    }

    /**
     * 成功时候的调用
     *
     * @return
     */
    public static Result success(Object data, String msg, int count) {
        return new Result(data, msg, 200, count);
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Result success(String msg) {
        return (Result) Result.success("", msg, 0);
    }

    /**
     * 失败时候的调用
     *
     * @return
     */
    public static Result error(Object data) {
        return Result.error(data, "操作失败");
    }

    /**
     * 失败时候的调用,扩展消息参数
     *
     * @param data
     * @param msg
     * @return
     */
    public static Result error(Object data, String msg) {
        return new Result(data, msg, 500, 0);
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Result error(String msg) {
        return Result.error("", msg);
    }


}
