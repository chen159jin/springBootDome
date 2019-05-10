package com.jin.demo.controller;

import com.jin.demo.entity.Dept;
import com.jin.demo.service.DeptService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "dept";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public Dept selectOne(Long id) {
        return this.deptService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param dept
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectDept(Model model, @RequestParam(required = false) Dept dept, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> deptList = this.deptService.queryAll(dept);
        return Result.success(deptList);
    }
}