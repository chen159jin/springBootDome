package com.jin.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Jin
 * @Title: SuperDao
 * @ProjectName
 * @Description: TODO
 * @date 2019/5/1/00114:53
 */
public interface SuperDao<T, K> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    T queryById(K id);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param entity 实例对象
     * @return 对象列表
     */
    List<T> queryAll(T entity);

    /**
     * 新增数据
     *
     * @param entity 实例对象
     * @return 影响行数
     */
    int insert(T entity);

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 影响行数
     */
    int update(T entity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(K id);
   
}