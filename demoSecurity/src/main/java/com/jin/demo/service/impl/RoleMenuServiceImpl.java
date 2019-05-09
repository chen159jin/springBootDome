package com.jin.demo.service.impl;

import com.jin.demo.entity.RoleMenu;
import com.jin.demo.dao.RoleMenuDao;
import com.jin.demo.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {

 private static final Logger LOGGER = LoggerFactory.getLogger(RoleMenuService.class);
    @Resource
    private RoleMenuDao roleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public RoleMenu queryById( ) {
        return this.roleMenuDao.queryById();
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param roleMenu 实例对象
     * @return 对象列表
     */
     @Override
    public List<RoleMenu> queryAll(RoleMenu roleMenu){
        return this.roleMenuDao.queryAll(roleMenu);
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu insert(RoleMenu roleMenu) {
        this.roleMenuDao.insert(roleMenu);
        return roleMenu;
    }

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu update(RoleMenu roleMenu) {
        this.roleMenuDao.update(roleMenu);
        return this.queryById(roleMenu.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.roleMenuDao.deleteById() > 0;
    }
}