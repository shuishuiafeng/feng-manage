package com.feng.manage.server.user.provider;


import com.feng.manage.common.exception.BusinessRuntimeException;
import com.feng.manage.common.result.Result;
import com.feng.manage.common.result.enums.BusinessCode;
import com.feng.manage.common.result.helper.ResultHelper;
import com.feng.manage.data.storage.user.po.User;
import com.feng.manage.data.storage.user.po.ext.UserExt;
import com.feng.manage.server.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Administrator
 * @since 2019-07-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;


    @GetMapping("/test")
    public String getInfoTest(){
        User user = userService.selectById(1);
        return user.getNickName();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if(user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            throw new BusinessRuntimeException(BusinessCode.NULL_PARAMS);
        }
        String username = user.getUsername().toLowerCase();
        String password = user.getPassword().toLowerCase();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            return ResultHelper.buildFail("password error");
        }catch (UnknownAccountException uae) {
            return ResultHelper.buildFail("username error");
        }
        Object o = subject.getPrincipal();
        UserExt userExt = userService.getUserExtByUserName((String)o);
        subject.getSession().setAttribute("sessionUser", userExt);
        return ResultHelper.buildSuccess();
    }
}

