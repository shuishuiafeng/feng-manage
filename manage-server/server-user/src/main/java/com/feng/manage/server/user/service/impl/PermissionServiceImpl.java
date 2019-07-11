package com.feng.manage.server.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.feng.manage.data.storage.user.po.Permission;
import com.feng.manage.data.storage.user.mapper.PermissionMapper;
import com.feng.manage.server.user.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-09
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<Permission> getPermissions() {
        Wrapper<Permission> wrapper = new EntityWrapper<>();
        wrapper.isNull("parent_id")
                .or()
                .eq("parent_id", 0)
                .orderBy("sort_order");
        List<Permission> permissions = this.selectList(wrapper);// 得到一级父菜单权限
        if(permissions != null && permissions.size() > 0){
            permissions.forEach(this::findRelatedAllChild); // 得到每个一级菜单名下的子菜单，以及子菜单下的子子菜单……赋予到对应的children属性上
        }
        return permissions;
    }

    @Override
    public void findRelatedAllChild(Permission permission) {
        Wrapper<Permission> wrapper = new EntityWrapper<>();
        wrapper.eq("parent_id", permission.getId()).orderBy("sort_order");
        List<Permission> permissions = this.selectList(wrapper);// 找到子权限列表们
        permission.setChildren(permissions);
        if(permissions != null && permissions.size() > 0){
            permissions.forEach(this::findRelatedAllChild); // 获取子权限的子权限们
        }
    }


}
