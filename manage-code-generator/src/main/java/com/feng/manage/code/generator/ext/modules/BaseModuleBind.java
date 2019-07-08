package com.feng.manage.code.generator.ext.modules;

import lombok.Builder;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:18
 * @Description: 模块与子详细模块绑定
 */
@Builder
public class BaseModuleBind implements IModuleBind{

    private ModuleInfoTemplateTypeEnum moduleInfoTemplateType;
    protected IModuleInfo moduleInfo;

    public BaseModuleBind(ModuleInfoTemplateTypeEnum moduleInfoTemplateType, IModuleInfo moduleInfo) {
        this.moduleInfoTemplateType = moduleInfoTemplateType;
        this.moduleInfo = moduleInfo;
    }

    @Override
    public ModuleInfoTemplateTypeEnum getTemplate() {
        return moduleInfoTemplateType;
    }

    @Override
    public IModuleInfo getModuleInfo() {
        return moduleInfo;
    }
}
