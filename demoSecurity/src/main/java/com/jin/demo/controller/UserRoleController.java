package com.jin.demo.controller;

import com.jin.demo.entity.UserRole;
import com.jin.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRole)表控制层
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Controller
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "/userRole";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public UserRole selectOne( id) {
        return this.userRoleService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param userRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectUserRole(Model model, @RequestParam(required = false) UserRole userRole, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserRole> userRoleList = this.userRoleService.queryAll(userRole);
        return Result.success(userRoleList);
    }
}