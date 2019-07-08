package com.feng.manage.code.generator.ext.items;

import com.feng.manage.code.generator.ext.modules.IModuleBind;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:26
 * @Description: 条目接口——针对order、user等某个条目模块获取设置相关联的controller、service、entity等基本模块
 */
public interface IItem {

    IModuleBind getController();

    IModuleBind getService();

    IModuleBind getServiceImpl();

    IModuleBind getMapper();

    IModuleBind getMapperXml();

    IModuleBind getEntity();

}
