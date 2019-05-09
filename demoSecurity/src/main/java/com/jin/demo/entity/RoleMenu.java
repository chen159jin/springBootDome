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
 * @since 2019-05-01 15:17:58
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -44878138208108845L;
    /**角色ID*/
    private Long roleId;
    /**菜单/按钮ID*/
    private Long menuId;



}