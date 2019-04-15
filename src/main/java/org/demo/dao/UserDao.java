package org.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.demo.entity.User;

/**
 * Created with IDEA
 * author:ligang
 * Date:2019/4/15
 * Time:11:33
 * Description:
 */
public interface UserDao {
    Integer queryUser(@Param("userName")String userName,@Param("password")String password);

    User getUserById(@Param("id")Integer id);
}
