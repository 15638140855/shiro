package com.wang.shiro.mapper;


import com.wang.shiro.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    /*登录*/
    List<UserLogin> UserLogin(UserLogin user);

    /*注册*/
    Integer insertUser(UserLogin user);
}
