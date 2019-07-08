package com.feng.manage.code.generator.ext.items;

import com.feng.manage.code.generator.ext.modules.BaseModuleBind;
import com.feng.manage.code.generator.ext.modules.BaseModuleInfo;
import com.feng.manage.code.generator.ext.modules.ModuleInfoEnum;
import com.feng.manage.code.generator.ext.modules.ModuleInfoTemplateTypeEnum;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:26
 * @Description: 条目枚举（user、order等模块配置对应的绑定信息）
 */
public enum ItemEnum {
    USER(
            BaseItem.builder()
            .controller(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.SERVER_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.CONTROLLER)
                            .build()
            )
            .service(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.SERVER_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.SERVICE)
                            .build()
            )
            .serviceImpl(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.SERVER_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.SERVICE_IMPL)
                            .build()
            )
            .mapper(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.DATA_STORAGE_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.MAPPER)
                            .build()
            )
            .mapperXml(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.DATA_STORAGE_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.MAPPER_XML)
                            .build()
            )
            .entity(
                    BaseModuleBind.builder()
                            .moduleInfo(ModuleInfoEnum.DATA_STORAGE_USER.getModuleInfo())
                            .moduleInfoTemplateType(ModuleInfoTemplateTypeEnum.PO)
                            .build()
            )
            .build()
    );

    private IItem item;

    ItemEnum(IItem item) {
        this.item = item;
    }

    public IItem getItem() {
        return item;
    }
}
