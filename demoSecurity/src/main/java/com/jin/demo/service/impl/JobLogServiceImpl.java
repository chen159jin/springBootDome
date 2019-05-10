package com.jin.demo.service.impl;

import com.jin.demo.entity.JobLog;
import com.jin.demo.dao.JobLogDao;
import com.jin.demo.service.JobLogService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JobLog)表服务实现类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Service("jobLogService")
public class JobLogServiceImpl implements JobLogService {

 private static final Logger LOGGER = LoggerFactory.getLogger(JobLogService.class);
    @Resource
    private JobLogDao jobLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    public JobLog queryById(Long logId) {
        return this.jobLogDao.queryById(logId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param jobLog 实例对象
     * @return 对象列表
     */
     @Override
    public List<JobLog> queryAll(JobLog jobLog){
        return this.jobLogDao.queryAll(jobLog);
    }

    /**
     * 新增数据
     *
     * @param jobLog 实例对象
     * @return 实例对象
     */
    @Override
    public JobLog insert(JobLog jobLog) {
        this.jobLogDao.insert(jobLog);
        return jobLog;
    }

    /**
     * 修改数据
     *
     * @param jobLog 实例对象
     * @return 实例对象
     */
    @Override
    public JobLog update(JobLog jobLog) {
        this.jobLogDao.update(jobLog);
        return this.queryById(jobLog.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long logId) {
        return this.jobLogDao.deleteById(logId) > 0;
    }
}