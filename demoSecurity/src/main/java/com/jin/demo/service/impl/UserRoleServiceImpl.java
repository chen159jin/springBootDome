package com.jin.demo.service.impl;

import com.jin.demo.entity.UserRole;
import com.jin.demo.dao.UserRoleDao;
import com.jin.demo.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRole)表服务实现类
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

 private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleService.class);
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Long id ) {
        return this.userRoleDao.queryById(id);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param userRole 实例对象
     * @return 对象列表
     */
     @Override
    public List<UserRole> queryAll(UserRole userRole){
        return this.userRoleDao.queryAll(userRole);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.userRoleDao.deleteById() > 0;
    }
}