package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2019-05-01 15:17:57
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {
    private static final long serialVersionUID = 503682440642321472L;
    /**角色ID*/
    private Long roleId;
    /**角色名称*/
    private String roleName;
    /**角色描述*/
    private String remark;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date modifyTime;



}