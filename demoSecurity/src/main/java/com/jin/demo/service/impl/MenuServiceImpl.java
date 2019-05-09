package com.jin.demo.service.impl;

import com.jin.demo.entity.Menu;
import com.jin.demo.dao.MenuDao;
import com.jin.demo.service.MenuService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2019-05-01 15:17:57
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

 private static final Logger LOGGER = LoggerFactory.getLogger(MenuService.class);
    @Resource
    private MenuDao menuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(Long menuId) {
        return this.menuDao.queryById(menuId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
     @Override
    public List<Menu> queryAll(Menu menu){
        return this.menuDao.queryAll(menu);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insert(Menu menu) {
        this.menuDao.insert(menu);
        return menu;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuDao.update(menu);
        return this.queryById(menu.getMenuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long menuId) {
        return this.menuDao.deleteById(menuId) > 0;
    }
}