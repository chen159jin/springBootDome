package com.jin.demo.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (RoleMenu)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -51245308232821212L;
    
    private Long id;
    /**角色ID*/
    private Long roleId;
    /**菜单/按钮ID*/
    private Long menuId;



}