package com.feng.manage.server.user.provider;


import com.feng.manage.common.result.Result;
import com.feng.manage.common.result.helper.ResultHelper;
import com.feng.manage.data.storage.user.po.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Administrator
 * @since 2019-07-09
 */
@RestController
@RequestMapping("/feng/role")
public class RoleController {

    @PostMapping("/save")
    public Result login() {
        return ResultHelper.buildSuccess("hhhh");
    }

    @PostMapping("/edit")
    public Result edit() {
        return ResultHelper.buildSuccess("hohohoho");
    }

}

