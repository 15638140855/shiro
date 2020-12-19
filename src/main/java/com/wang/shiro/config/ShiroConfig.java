package com.wang.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.catalina.User;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //Shirofillterfactorybean
    @Bean
public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
    ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
    /*设置安全管理器*/
    bean.setSecurityManager(defaultWebSecurityManager);
    //添加shiro的内置过滤器

    /* * anon：无需认证就可以访问
     * aoth：必须认证
     * user：必须有记住我功能
     * perms：拥有对某个资源的权限
     * role：拥有某个角色权限才能访问
     * */
        Map<String,String> filterMap=new LinkedHashMap<>();
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/upd","perms[user:upd]");
        filterMap.put("/user/*","authc");
      bean.setFilterChainDefinitionMap(filterMap);
     bean.setLoginUrl("/tologin");
     bean.setUnauthorizedUrl("/noauth");


    return bean;
}
    //dafaultwebsecruityManager
    @Bean(name = "defaultWebSecurityManager")
  public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
      DefaultWebSecurityManager securityManager= new DefaultWebSecurityManager();
      //关联Realm
      securityManager.setRealm(userRealm);
      return securityManager;
  }

    //创建realm对象（自定义）
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合ShiroDualect：用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
