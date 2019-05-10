package com.jin.demo.service;

import com.jin.demo.entity.JobLog;
import java.util.List;

/**
 * (JobLog)表服务接口
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
public interface JobLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    JobLog queryById(Long logId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param jobLog 实例对象
     * @return 对象列表
     */
    List<JobLog> queryAll(JobLog jobLog);

    /**
     * 新增数据
     *
     * @param jobLog 实例对象
     * @return 实例对象
     */
    JobLog insert(JobLog jobLog);

    /**
     * 修改数据
     *
     * @param jobLog 实例对象
     * @return 实例对象
     */
    JobLog update(JobLog jobLog);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    boolean deleteById(Long logId);

}