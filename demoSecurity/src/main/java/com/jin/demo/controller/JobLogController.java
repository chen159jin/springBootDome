package com.jin.demo.controller;

import com.jin.demo.entity.JobLog;
import com.jin.demo.service.JobLogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JobLog)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("jobLog")
public class JobLogController {
    /**
     * 服务对象
     */
    @Resource
    private JobLogService jobLogService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "jobLog";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public JobLog selectOne(Long id) {
        return this.jobLogService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param jobLog
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectJobLog(Model model, @RequestParam(required = false) JobLog jobLog, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<JobLog> jobLogList = this.jobLogService.queryAll(jobLog);
        return Result.success(jobLogList);
    }
}