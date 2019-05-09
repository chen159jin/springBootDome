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
 * @since 2019-05-01 15:17:58
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole implements Serializable {
    private static final long serialVersionUID = 241246062835774298L;
    /**用户ID*/
    private Long userId;
    /**角色ID*/
    private Long roleId;



}