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
 * @since 2019-05-10 16:58:34
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole implements Serializable {
    private static final long serialVersionUID = 545705075016669738L;
    
    private Long id;
    /**用户ID*/
    private Long userId;
    /**角色ID*/
    private Long roleId;



}