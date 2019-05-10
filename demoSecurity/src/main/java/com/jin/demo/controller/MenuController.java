package com.jin.demo.controller;

import com.jin.demo.entity.Menu;
import com.jin.demo.service.MenuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "menu";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public Menu selectOne(Long id) {
        return this.menuService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param menu
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectMenu(Model model, @RequestParam(required = false) Menu menu, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Menu> menuList = this.menuService.queryAll(menu);
        return Result.success(menuList);
    }
}