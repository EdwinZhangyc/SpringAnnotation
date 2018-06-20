package com.zyc.annotation.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser() {

        userDao.insertUser();
        System.out.println("插入成功");
        int i = 1/0;
    }
}