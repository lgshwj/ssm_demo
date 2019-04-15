package org.demo.service.impl;

import org.demo.dao.UserDao;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:ligang
 * Date:2019/4/15
 * Time:13:50
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean loginCheck(String userName, String password) {
        Integer status = userDao.queryUser(userName,password);
        if (status<1)
            return false;
        else
            return true;
    }
}
