package org.demo.service;

import org.demo.entity.User;

/**
 * Created with IDEA
 * author:ligang
 * Date:2019/4/15
 * Time:11:31
 * Description:
 */
public interface UserService {
    boolean loginCheck(String userName,String password);

    User findUserWithId(Integer id);
}
