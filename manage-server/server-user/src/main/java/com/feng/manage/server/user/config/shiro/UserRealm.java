package com.feng.manage.server.user.config.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.feng.manage.data.storage.user.po.Permission;
import com.feng.manage.data.storage.user.po.Role;
import com.feng.manage.data.storage.user.po.User;
import com.feng.manage.data.storage.user.po.ext.RoleExt;
import com.feng.manage.data.storage.user.po.ext.UserExt;
import com.feng.manage.server.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 9:56
 * @Description: 用户认证赋权用到的Realm
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String)principals.getPrimaryPrincipal();

        UserExt userExt = userService.getUserExtByUserName(userName);

        for(RoleExt role : userExt.getRoles()) {
            authorizationInfo.addRole(role.getName());
            for(Permission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 获取登陆验证主体
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//        String username = (String) token.getPrincipal();
        UserExt userExt = userService.getUserExtByUserName(usernamePasswordToken.getUsername());
        if(userExt == null){
            return null;
        }
        SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(userExt.getUsername(), userExt.getPassword(), new Md5Hash(userExt.getSalt()), getName());
        return authorizationInfo;
    }

    /**
     * 设置密码加盐方式
     *
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroKit.HASH_ALGORITHM_NAME);
        hashedCredentialsMatcher.setHashIterations(ShiroKit.HASH_ITERATIONS);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

}
