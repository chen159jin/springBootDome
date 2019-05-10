package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Log implements Serializable {
    private static final long serialVersionUID = 150280704516531069L;
    /**日志ID*/
    private Long id;
    /**操作用户*/
    private String username;
    /**操作内容*/
    private String operation;
    /**耗时*/
    private Double time;
    /**操作方法*/
    private String method;
    /**方法参数*/
    private String params;
    /**操作者IP*/
    private String ip;
    /**创建时间*/
    private Date createTime;
    /**操作地点*/
    private String location;



}