package com.jin.demo.service;

import com.jin.demo.entity.RoleMenu;

import java.util.List;

/**
 * (RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
public interface RoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id  主键
     * @return 实例对象
     */
    RoleMenu queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleMenu 实例对象
     * @return 对象列表
     */
    List<RoleMenu> queryAll(RoleMenu roleMenu);

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu insert(RoleMenu roleMenu);

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu update(RoleMenu roleMenu);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 是否成功
     */
    boolean deleteById();

}