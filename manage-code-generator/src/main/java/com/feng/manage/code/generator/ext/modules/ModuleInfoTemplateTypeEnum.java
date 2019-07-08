package com.feng.manage.code.generator.ext.modules;

import com.baomidou.mybatisplus.generator.config.ConstVal;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:06
 * @Description: 模块下 具体的类型信息包(packageName)-模板类 枚举
 * （比如模块指的是server-user,此处的枚举类型信息指的则是其名下的mapper、service、po等，包含他们的packageName名称与对应的模板文件对应
 * 自己就是自己枚举类的具体类
 */
public enum ModuleInfoTemplateTypeEnum {
    API("api"),
    CONTROLLER("provider") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_CONTROLLER;
        }
    }, /*Controller文件*/
    BUSINESS("bussiness"),/*BUSINESS文件*/
    SERVICE("service") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_SERVICE;
        }
    },/*Server文件*/
    SERVICE_IMPL("service.impl") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_SERVICEIMPL;
        }
    }, /*Server实现类文件*/
    MAPPER("mapper") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_MAPPER;
        }
    }, /*Mapper文件*/
    MAPPER_XML("mapper") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_XML;
        }
    },/*Mapper xml文件*/
    VO("vo"),/*VO*/
    DTO("dto"),/*DTO*/
    BO("bo"),/*BO*/
    PO("po") {
        @Override
        public String getTemplate() {
            return ConstVal.TEMPLATE_ENTITY_JAVA;
        }
    };/*PO*/;
    String packageName;

    ModuleInfoTemplateTypeEnum(String packageName) {
        this.packageName = packageName;
    }

    public String getTemplate() {
        throw new UnsupportedOperationException(String.format("不支持%s文件的生成操作。", name()));
    }

    public String getPackageName() {
        return packageName;
    }
}
