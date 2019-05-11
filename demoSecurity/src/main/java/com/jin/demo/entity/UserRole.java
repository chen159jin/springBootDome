package com.jin.demo.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (UserRole)实体类
 *
 * @author makejava
 * @since 2019-05-11 10:11:07
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole implements Serializable {
    private static final long serialVersionUID = -55683312502218884L;
    
    private Long id;
    /**用户ID*/
    private Long userId;
    /**角色ID*/
    private Long roleId;



}