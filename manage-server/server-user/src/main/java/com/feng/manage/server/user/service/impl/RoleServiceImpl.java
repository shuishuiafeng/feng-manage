package com.feng.manage.server.user.service.impl;

import com.feng.manage.data.storage.user.po.Role;
import com.feng.manage.data.storage.user.mapper.RoleMapper;
import com.feng.manage.server.user.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
