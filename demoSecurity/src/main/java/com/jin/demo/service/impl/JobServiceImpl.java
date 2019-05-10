package com.jin.demo.service.impl;

import com.jin.demo.entity.Job;
import com.jin.demo.dao.JobDao;
import com.jin.demo.service.JobService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Service("jobService")
public class JobServiceImpl implements JobService {

 private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);
    @Resource
    private JobDao jobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jobId 主键
     * @return 实例对象
     */
    @Override
    public Job queryById(Long jobId) {
        return this.jobDao.queryById(jobId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param job 实例对象
     * @return 对象列表
     */
     @Override
    public List<Job> queryAll(Job job){
        return this.jobDao.queryAll(job);
    }

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job insert(Job job) {
        this.jobDao.insert(job);
        return job;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job update(Job job) {
        this.jobDao.update(job);
        return this.queryById(job.getJobId());
    }

    /**
     * 通过主键删除数据
     *
     * @param jobId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long jobId) {
        return this.jobDao.deleteById(jobId) > 0;
    }
}