package com.feng.manage.server.user.service;

import com.feng.manage.data.storage.user.po.Permission;

import java.util.List;
import java.util.Map;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/11 13:32
 * @Description:
 */
public interface IShiroService {

    /**
     * 获取拦截器数据
     *
     * @return
     */
    Map<String, String> getFilterChainDefinitionMap();

    /**
     * 将权限下的子权限资源们进行迭代，加入用于后期通过filterChainDefinitionMap处理的参数列表permsList中
     * @param permission 权限
     * @param permsList 整个permsList资源权限类别
     */
    void iterationAllResourceInToFilter(Permission permission, List<String[]> permsList);

}
