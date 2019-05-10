package com.jin.demo.service;

import com.jin.demo.entity.Dict;
import java.util.List;

/**
 * (Dict)表服务接口
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
public interface DictService {

    /**
     * 通过ID查询单条数据
     *
     * @param dictId 主键
     * @return 实例对象
     */
    Dict queryById(Long dictId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param dict 实例对象
     * @return 对象列表
     */
    List<Dict> queryAll(Dict dict);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict insert(Dict dict);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict update(Dict dict);

    /**
     * 通过主键删除数据
     *
     * @param dictId 主键
     * @return 是否成功
     */
    boolean deleteById(Long dictId);

}