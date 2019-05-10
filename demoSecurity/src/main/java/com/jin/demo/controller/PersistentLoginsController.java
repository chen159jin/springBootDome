package com.jin.demo.controller;

import com.jin.demo.entity.PersistentLogins;
import com.jin.demo.service.PersistentLoginsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersistentLogins)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("persistentLogins")
public class PersistentLoginsController {
    /**
     * 服务对象
     */
    @Resource
    private PersistentLoginsService persistentLoginsService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "persistentLogins";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public PersistentLogins selectOne(String id) {
        return this.persistentLoginsService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param persistentLogins
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectPersistentLogins(Model model, @RequestParam(required = false) PersistentLogins persistentLogins, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PersistentLogins> persistentLoginsList = this.persistentLoginsService.queryAll(persistentLogins);
        return Result.success(persistentLoginsList);
    }
}