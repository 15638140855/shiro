package com.wang.shiro;

import com.wang.shiro.pojo.UserLogin;
import com.wang.shiro.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {
    @Autowired
    private UserLoginService userLoginService;

    @Test
    void contextLoads() {
        UserLogin us = new UserLogin();
        us.setUser_name("wangguan");
        System.out.println(userLoginService.UserLogin(us));
    }

}
