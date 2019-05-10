package com.jin.demo.service.impl;

import com.jin.demo.entity.Dept;
import com.jin.demo.dao.DeptDao;
import com.jin.demo.service.DeptService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

 private static final Logger LOGGER = LoggerFactory.getLogger(DeptService.class);
    @Resource
    private DeptDao deptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Long deptId) {
        return this.deptDao.queryById(deptId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param dept 实例对象
     * @return 对象列表
     */
     @Override
    public List<Dept> queryAll(Dept dept){
        return this.deptDao.queryAll(dept);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept insert(Dept dept) {
        this.deptDao.insert(dept);
        return dept;
    }

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept update(Dept dept) {
        this.deptDao.update(dept);
        return this.queryById(dept.getDeptId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long deptId) {
        return this.deptDao.deleteById(deptId) > 0;
    }
}