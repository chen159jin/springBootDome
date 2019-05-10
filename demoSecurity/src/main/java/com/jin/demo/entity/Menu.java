package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Menu implements Serializable {
    private static final long serialVersionUID = -18145466470494915L;
    /**菜单/按钮ID*/
    private Long menuId;
    /**上级菜单ID*/
    private Long parentId;
    /**菜单/按钮名称*/
    private String menuName;
    /**菜单URL*/
    private String url;
    /**权限标识*/
    private String perms;
    /**图标*/
    private String icon;
    /**类型 0菜单 1按钮*/
    private String type;
    /**排序*/
    private Long orderNum;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date modifyTime;



}