package com.jin.demo.controller;

import com.jin.demo.entity.Dict;
import com.jin.demo.service.DictService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.jin.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dict)表控制层
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Controller
@RequestMapping("dict")
public class DictController {
    /**
     * 服务对象
     */
    @Resource
    private DictService dictService;
    /**
     * 进入页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "dict";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public Dict selectOne(Long id) {
        return this.dictService.queryById(id);
    }

     /**
     * 通过获取列表
     * @param model
     * @param dict
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result selectDict(Model model, @RequestParam(required = false) Dict dict, 
    @RequestParam(value="pageNum")Integer pageNum,
    @RequestParam(value = "pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dict> dictList = this.dictService.queryAll(dict);
        return Result.success(dictList);
    }
}