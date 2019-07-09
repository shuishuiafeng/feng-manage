package com.feng.manage.server.user.service;

import com.feng.manage.data.storage.user.po.User;
import com.baomidou.mybatisplus.service.IService;
import com.feng.manage.data.storage.user.po.ext.UserExt;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-08
 */
public interface IUserService extends IService<User> {

    UserExt getUserExtByUserName(String userName);

}
