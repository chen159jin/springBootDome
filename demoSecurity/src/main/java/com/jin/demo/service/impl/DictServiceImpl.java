package com.jin.demo.service.impl;

import com.jin.demo.entity.Dict;
import com.jin.demo.dao.DictDao;
import com.jin.demo.service.DictService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dict)表服务实现类
 *
 * @author makejava
 * @since 2019-05-10 16:58:35
 */
@Service("dictService")
public class DictServiceImpl implements DictService {

 private static final Logger LOGGER = LoggerFactory.getLogger(DictService.class);
    @Resource
    private DictDao dictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dictId 主键
     * @return 实例对象
     */
    @Override
    public Dict queryById(Long dictId) {
        return this.dictDao.queryById(dictId);
    }

     /**
     * 通过实体作为筛选条件查询
     *
     * @param dict 实例对象
     * @return 对象列表
     */
     @Override
    public List<Dict> queryAll(Dict dict){
        return this.dictDao.queryAll(dict);
    }

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict insert(Dict dict) {
        this.dictDao.insert(dict);
        return dict;
    }

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict update(Dict dict) {
        this.dictDao.update(dict);
        return this.queryById(dict.getDictId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dictId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long dictId) {
        return this.dictDao.deleteById(dictId) > 0;
    }
}