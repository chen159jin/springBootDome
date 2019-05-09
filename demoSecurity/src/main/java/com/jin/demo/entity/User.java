package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 624639678993724350L;
    /**用户ID*/
    private Long userId;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**部门ID*/
    private Long deptId;
    /**邮箱*/
    private String email;
    /**联系电话*/
    private String mobile;
    /**状态 0锁定 1有效*/
    private String status;
    /**创建时间*/
    private Date crateTime;
    /**修改时间*/
    private Date modifyTime;
    /**最近访问时间*/
    private Date lastLoginTime;
    /**性别 0男 1女*/
    private String ssex;
    /**主题*/
    private String theme;
    /**头像*/
    private String avatar;
    /**描述*/
    private String description;



}