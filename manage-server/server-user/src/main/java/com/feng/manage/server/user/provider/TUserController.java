package com.feng.manage.server.user.provider;


import com.alibaba.druid.support.json.JSONUtils;
import com.feng.manage.data.storage.user.po.TUser;
import com.feng.manage.server.user.service.ITUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class TUserController {

    @Resource
    private ITUserService userService;


    @GetMapping("/test")
    public String getInfoTest(){
        TUser user = userService.selectById(1);
        return user.getNickName();
    }
}

