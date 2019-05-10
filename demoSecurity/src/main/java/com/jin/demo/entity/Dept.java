package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Dept implements Serializable {
    private static final long serialVersionUID = 288261681588707230L;
    /**部门ID*/
    private Long deptId;
    /**上级部门ID*/
    private Long parentId;
    /**部门名称*/
    private String deptName;
    /**排序*/
    private Long orderNum;
    /**创建时间*/
    private Date createTime;



}