package com.wang.shiro.service.impl;


import com.wang.shiro.mapper.UserLoginMapper;
import com.wang.shiro.pojo.UserLogin;
import com.wang.shiro.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceimpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    public List<UserLogin> UserLogin(UserLogin user) {
        return userLoginMapper.UserLogin(user);
    }

    public Integer insertUser(UserLogin user) {
        return userLoginMapper.insertUser(user);
    }
}
