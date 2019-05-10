package com.jin.demo.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (Dict)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Dict implements Serializable {
    private static final long serialVersionUID = -20589035231630356L;
    /**字典ID*/
    private Long dictId;
    /**键*/
    private Long keyy;
    /**值*/
    private String valuee;
    /**字段名称*/
    private String fieldName;
    /**表名*/
    private String tableName;



}