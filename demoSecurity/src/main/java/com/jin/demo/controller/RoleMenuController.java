package com.jin.demo.controller;

import com.jin.demo.entity.RoleMenu;
import com.jin.demo.service.RoleMenuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleMenu)表控制层
 *
 * @author makejava
 * @since 2019-05-11 10:11:19
 */
@Controller
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "roleMenu";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public RoleMenu selectOne(Long id) {
        return this.roleMenuService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param roleMenu
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectRoleMenu(Model model, @RequestParam(required = false) RoleMenu roleMenu, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RoleMenu> roleMenuList = this.roleMenuService.queryAll(roleMenu);
        return Result.success(roleMenuList);
    }
}