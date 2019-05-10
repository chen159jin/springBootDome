package com.jin.demo.service.impl;

import com.jin.demo.entity.PersistentLogins;
import com.jin.demo.dao.PersistentLoginsDao;
import com.jin.demo.service.PersistentLoginsService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersistentLogins)表服务实现类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Service("persistentLoginsService")
public class PersistentLoginsServiceImpl implements PersistentLoginsService {

 private static final Logger LOGGER = LoggerFactory.getLogger(PersistentLoginsService.class);
    @Resource
    private PersistentLoginsDao persistentLoginsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param series 主键
     * @return 实例对象
     */
    @Override
    public PersistentLogins queryById(String series) {
        return this.persistentLoginsDao.queryById(series);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param persistentLogins 实例对象
     * @return 对象列表
     */
     @Override
    public List<PersistentLogins> queryAll(PersistentLogins persistentLogins){
        return this.persistentLoginsDao.queryAll(persistentLogins);
    }

    /**
     * 新增数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    @Override
    public PersistentLogins insert(PersistentLogins persistentLogins) {
        this.persistentLoginsDao.insert(persistentLogins);
        return persistentLogins;
    }

    /**
     * 修改数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    @Override
    public PersistentLogins update(PersistentLogins persistentLogins) {
        this.persistentLoginsDao.update(persistentLogins);
        return this.queryById(persistentLogins.getSeries());
    }

    /**
     * 通过主键删除数据
     *
     * @param series 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String series) {
        return this.persistentLoginsDao.deleteById(series) > 0;
    }
}