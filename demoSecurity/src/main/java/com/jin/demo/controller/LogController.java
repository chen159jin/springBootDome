package com.jin.demo.controller;

import com.jin.demo.entity.Log;
import com.jin.demo.service.LogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Log)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "log";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public Log selectOne(Long id) {
        return this.logService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param log
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectLog(Model model, @RequestParam(required = false) Log log, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Log> logList = this.logService.queryAll(log);
        return Result.success(logList);
    }
}