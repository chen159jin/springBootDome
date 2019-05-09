package com.jin.demo.service.impl;

import com.jin.demo.entity.Log;
import com.jin.demo.dao.LogDao;
import com.jin.demo.service.LogService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Log)表服务实现类
 *
 * @author makejava
 * @since 2019-05-01 15:17:57
 */
@Service("logService")
public class LogServiceImpl implements LogService {

 private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);
    @Resource
    private LogDao logDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(Long id) {
        return this.logDao.queryById(id);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param log 实例对象
     * @return 对象列表
     */
     @Override
    public List<Log> queryAll(Log log){
        return this.logDao.queryAll(log);
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log insert(Log log) {
        this.logDao.insert(log);
        return log;
    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.logDao.deleteById(id) > 0;
    }
}