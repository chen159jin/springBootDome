package com.jin.demo.service;

import com.jin.demo.entity.PersistentLogins;
import java.util.List;

/**
 * (PersistentLogins)表服务接口
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
public interface PersistentLoginsService {

    /**
     * 通过ID查询单条数据
     *
     * @param series 主键
     * @return 实例对象
     */
    PersistentLogins queryById(String series);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param persistentLogins 实例对象
     * @return 对象列表
     */
    List<PersistentLogins> queryAll(PersistentLogins persistentLogins);

    /**
     * 新增数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    PersistentLogins insert(PersistentLogins persistentLogins);

    /**
     * 修改数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    PersistentLogins update(PersistentLogins persistentLogins);

    /**
     * 通过主键删除数据
     *
     * @param series 主键
     * @return 是否成功
     */
    boolean deleteById(String series);

}