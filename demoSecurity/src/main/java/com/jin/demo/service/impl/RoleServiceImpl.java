package com.jin.demo.service.impl;

import com.jin.demo.entity.Role;
import com.jin.demo.dao.RoleDao;
import com.jin.demo.service.RoleService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

 private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class);
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Long roleId) {
        return this.roleDao.queryById(roleId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
     @Override
    public List<Role> queryAll(Role role){
        return this.roleDao.queryAll(role);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId) {
        return this.roleDao.deleteById(roleId) > 0;
    }
}