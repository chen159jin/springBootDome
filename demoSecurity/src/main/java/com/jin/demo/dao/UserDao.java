package com.jin.demo.dao;

import com.jin.demo.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2019-05-01 15:17:58
 */
 @Repository
public interface UserDao extends SuperDao<User,Long> {
  User findUserByUsername(String userNmae);

}