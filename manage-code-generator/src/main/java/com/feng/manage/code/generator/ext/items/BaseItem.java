package com.feng.manage.code.generator.ext.items;

import com.feng.manage.code.generator.ext.modules.BaseModuleBind;
import com.feng.manage.code.generator.ext.modules.IModuleBind;
import lombok.Builder;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:23
 * @Description: 条目(user、order等）生成和获取
 */
@Builder
public class BaseItem implements IItem{
    private BaseModuleBind controller;
    private BaseModuleBind service;
    private BaseModuleBind serviceImpl;
    private BaseModuleBind mapper;
    private BaseModuleBind mapperXml;
    private BaseModuleBind entity;

    @Override
    public IModuleBind getController() {
        return controller;
    }

    @Override
    public IModuleBind getService() {
        return service;
    }

    @Override
    public IModuleBind getServiceImpl() {
        return serviceImpl;
    }

    @Override
    public IModuleBind getMapper() {
        return mapper;
    }

    @Override
    public IModuleBind getMapperXml() {
        return mapperXml;
    }

    @Override
    public IModuleBind getEntity() {
        return entity;
    }
}
