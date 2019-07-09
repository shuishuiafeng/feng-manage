package com.feng.manage.server.user.service.impl;

import com.feng.manage.data.storage.user.mapper.ext.UserMapperExt;
import com.feng.manage.data.storage.user.po.User;
import com.feng.manage.data.storage.user.mapper.UserMapper;
import com.feng.manage.data.storage.user.po.ext.UserExt;
import com.feng.manage.server.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapperExt userMapperExt;

    @Override
    public UserExt getUserExtByUserName(String userName) {
        return userMapperExt.getUserExtByUserName(userName);
    }
}
