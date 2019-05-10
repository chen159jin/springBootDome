package com.jin.demo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

/**
 * (PersistentLogins)实体类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PersistentLogins implements Serializable {
    private static final long serialVersionUID = -96356542117805125L;
    
    private String username;
    
    private String series;
    
    private String token;
    
    private Date lastUsed;



}