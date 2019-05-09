package com.jin.demo.controller;

import com.jin.demo.entity.User;
import com.jin.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "/user";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectUser(Model model, @RequestParam(required = false) User user, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = this.userService.queryAll(user);
        return Result.success(userList);
    }
}