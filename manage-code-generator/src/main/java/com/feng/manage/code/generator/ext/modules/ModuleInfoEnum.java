package com.feng.manage.code.generator.ext.modules;

import lombok.Getter;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:48
 * @Description: 模块信息枚举类——包含各种storage、server相关子模块的信息配置
 */
public enum  ModuleInfoEnum {

    /* 顶级模块 */
    TOP(BaseModuleInfo.builder().name("feng-manage").build()),

    /* 微Server模块 */
    SERVER(BaseModuleInfo.builder().name("manage-server").parent(TOP.moduleInfo).build()),
    SERVER_USER(BaseModuleInfo.builder().name("server-user").packageName("com.feng.manage.server.user").parent(SERVER.moduleInfo).build()),

    /* 微Storage数据仓模块*/
    DATA_STORAGE(BaseModuleInfo.builder().name("manage-data-storage").parent(TOP.moduleInfo).build()),
    DATA_STORAGE_USER(BaseModuleInfo.builder().name("manage-data-storage-user").packageName("com.feng.manage.data.storage.user").parent(DATA_STORAGE.moduleInfo).build()),
    ;

    @Getter
    private IModuleInfo moduleInfo;

    ModuleInfoEnum(IModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

}
