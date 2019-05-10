package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Job)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Job implements Serializable {
    private static final long serialVersionUID = -27029654116533578L;
    /**任务id*/
    private Long jobId;
    /**spring bean名称*/
    private String beanName;
    /**方法名*/
    private String methodName;
    /**参数*/
    private String params;
    /**cron表达式*/
    private String cronExpression;
    /**任务状态  0：正常  1：暂停*/
    private String status;
    /**备注*/
    private String remark;
    /**创建时间*/
    private Date createTime;



}