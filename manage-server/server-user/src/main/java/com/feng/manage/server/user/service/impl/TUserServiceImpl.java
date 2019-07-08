package com.feng.manage.server.user.service.impl;

import com.feng.manage.data.storage.user.po.TUser;
import com.feng.manage.data.storage.user.mapper.TUserMapper;
import com.feng.manage.server.user.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-08
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
