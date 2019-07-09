package com.feng.manage.server.user.service.impl;

import com.feng.manage.data.storage.user.po.Permission;
import com.feng.manage.data.storage.user.mapper.PermissionMapper;
import com.feng.manage.server.user.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-09
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
