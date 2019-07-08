package com.feng.manage.code.generator.ext.modules;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:34
 * @Description: 模块信息
 */
public interface IModuleInfo {

    /**
     * 父级模块信息
     */
    IModuleInfo getParent();
    /**
     * 模块名称
     */
    String getName();
    /**
     * 模块添加的前缀
     */
    String getPrefix();
    /**
     * 模块添加的后缀
     */
    String getSuffix();
    /**
     * 基础报名
     */
    String getPackageName();
    /**
     * 模块路径（以父级路径递归获取）
     */
    String getPathFromTop();
    /**
     * 模块绝对路径（basepath/--getPathFromTop--/src/main/java
     */
    String getAbsolutePath();
    /**
     * 模块生成文件的输出目录
     */
    String getOutDir();

}
