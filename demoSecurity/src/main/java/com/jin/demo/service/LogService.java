package com.jin.demo.service;

import com.jin.demo.entity.Log;
import java.util.List;

/**
 * (Log)表服务接口
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
public interface LogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param log 实例对象
     * @return 对象列表
     */
    List<Log> queryAll(Log log);

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}