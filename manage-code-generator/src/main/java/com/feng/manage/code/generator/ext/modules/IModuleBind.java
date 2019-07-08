package com.feng.manage.code.generator.ext.modules;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:33
 * @Description: 将ModuleInfo与ModuleInfoTemplateType关联，
 * eg: server-user.../com/feng/manage/storage/user与service/impl、mapper/子包模块关联
 */
public interface IModuleBind {
    ModuleInfoTemplateTypeEnum getTemplate();

    IModuleInfo getModuleInfo();
}
