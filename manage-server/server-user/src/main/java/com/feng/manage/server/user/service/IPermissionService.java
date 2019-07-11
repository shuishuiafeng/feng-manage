package com.feng.manage.server.user.service;

import com.feng.manage.data.storage.user.po.Permission;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-09
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 获取一级菜单权限
     * @return
     */
    List<Permission> getPermissions();

    /**
     * 获取对应菜单名下的所有子菜单元素
     * @param permission 菜单权限对象
     * @description 也会通过循环调用该方法获取子子菜单元素
     */
    void findRelatedAllChild(Permission permission);

}
