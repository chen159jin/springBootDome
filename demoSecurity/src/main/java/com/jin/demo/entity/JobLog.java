package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (JobLog)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class JobLog implements Serializable {
    private static final long serialVersionUID = 472557452896786908L;
    /**任务日志id*/
    private Long logId;
    /**任务id*/
    private Long jobId;
    /**spring bean名称*/
    private String beanName;
    /**方法名*/
    private String methodName;
    /**参数*/
    private String params;
    /**任务状态    0：成功    1：失败*/
    private String status;
    /**失败信息*/
    private String error;
    /**耗时(单位：毫秒)*/
    private Double times;
    /**创建时间*/
    private Date createTime;



}