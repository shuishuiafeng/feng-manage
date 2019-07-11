package com.feng.manage.server.user.config.shiro;

import com.feng.manage.server.user.service.IShiroService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 11:37
 * @Description: shiro配置
 */
@Configuration
public class ShiroConfig {

    @Resource
    private IShiroService shiroService;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterChainDefinitionMap = shiroService.getFilterChainDefinitionMap();
//        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("user", new CustomerAuthFilter());
        filterMap.put("perms", new PermissionAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public SessionManager sessionManager(SessionProperties sessionProperties) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionListeners(Arrays.asList(customSessionListener()));
        sessionManager.setSessionDAO(sessionRedisDAO());
        sessionManager.setGlobalSessionTimeout(sessionProperties.getTimeout()* 1000);
        sessionManager.setSessionValidationInterval(sessionProperties.getValidInterval()*1000);
        return sessionManager;
    }

    /**
     * session监听
     *
     * @return
     */
    @Bean
    public CustomSessionListener customSessionListener() {
        return new CustomSessionListener();
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean
    public RedisSessionDAO sessionRedisDAO(){
        return new RedisSessionDAO();
    }



}
