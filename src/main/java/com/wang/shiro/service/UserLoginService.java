package com.wang.shiro.service;


import com.wang.shiro.pojo.UserLogin;

import java.util.List;

public interface UserLoginService {
    /*登录*/
    List<UserLogin> UserLogin(UserLogin user);

    /*注册*/
    Integer insertUser(UserLogin user);
}
