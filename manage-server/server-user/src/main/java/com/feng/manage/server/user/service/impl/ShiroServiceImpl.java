package com.feng.manage.server.user.service.impl;

import com.feng.manage.data.storage.user.po.Permission;
import com.feng.manage.server.user.service.IPermissionService;
import com.feng.manage.server.user.service.IShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/11 13:33
 * @Description:
 */
@Service(value = "com.feng.manage.server.user.service.impl.ShiroServiceImpl")
public class ShiroServiceImpl implements IShiroService {

    @Resource
    private IPermissionService permissionService;

    @Override
    public Map<String, String> getFilterChainDefinitionMap() {
        /**
         * 注意添加到map中的权限的顺序，让子菜单权限在上方，所以添加位置索引都是0,先加父类再加子类子类在顶部
         */
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        List<String[]> permsList = new ArrayList<>();

        List<Permission> permissions = permissionService.getPermissions();
        if(permissions != null) {
            /** 开始将数据库表中的权限和路径对应关系给到filterChainDefinitionMap中，先只考虑权限配置，角色其实没必要但是也可以找到关联来配 */
            for(Permission permission : permissions) {
                if(!StringUtils.isEmpty(permission.getPath()) && !StringUtils.isEmpty(permission.getPermission())) {
                    if(!"".equals(permission.getPermission().trim())) {
                        permsList.add(0, new String[]{permission.getPath(), "perms["+permission.getPermission()+"]"});
                    }
                    iterationAllResourceInToFilter(permission, permsList);
                }
            }

            /** 将生成的权限资源数组添加到Map中 */
            for(String[] strings:permsList) {
                filterChainDefinitionMap.put(strings[0], strings[1]);
            }
            filterChainDefinitionMap.put("/**", "anon");
        }

        return filterChainDefinitionMap;
    }

    @Override
    public void iterationAllResourceInToFilter(Permission permission, List<String[]> permsList) {
        if(permission.getChildren()!=null && permission.getChildren().size()>0){
            for (Permission v : permission.getChildren()) {
                if(!StringUtils.isEmpty(v.getPath()) && !StringUtils.isEmpty(v.getPermission())){
                    permsList.add(0,new String[]{v.getPath(),"perms["+v.getPermission()+"]"}); // 越子越在0靠列表顶部添加，因为要注意顺序
                    iterationAllResourceInToFilter(v,permsList);
                }
            }
        }
    }

}
