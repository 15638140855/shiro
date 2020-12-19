package com.wang.shiro.config;

import com.wang.shiro.pojo.UserLogin;
import com.wang.shiro.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserLoginService userLoginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //SimpleAuthenticationInfo
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
        //拿到当前用户对象
        Subject subject=SecurityUtils.getSubject();
        UserLogin us= (UserLogin) subject.getPrincipal();
        //设置当前用户的权限。数据库读出来
        info.addStringPermission(us.getUser_qx());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        /*String name="root";
        String password="123456";*/
         UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        UserLogin us =new UserLogin();
        us.setUser_name(userToken.getUsername());
        List<UserLogin> list= userLoginService.UserLogin(us);
        if(list.size()==0){
            return null;
        }
        /*可以加密   ： md5  盐值加密 */
        //密码认证shiro来做
         return new SimpleAuthenticationInfo(list.get(0),list.get(0).getUser_pwd(),"");//list.get(0):当前用户

    }

}
