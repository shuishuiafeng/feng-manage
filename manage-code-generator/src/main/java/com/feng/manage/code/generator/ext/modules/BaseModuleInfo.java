package com.feng.manage.code.generator.ext.modules;

import com.feng.manage.code.generator.ext.helps.FileHelper;
import lombok.Builder;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:40
 * @Description: 模块信息具体实现类
 */
@Builder
public class BaseModuleInfo implements IModuleInfo{

    /**
     * 父级模块
     */
    protected IModuleInfo parent;
    /**
     * 模块名称
     */
    protected String name;
    /**
     * 子模块添加的前缀
     */
    protected String prefix;
    /**
     * 子模块添加的后缀
     */
    protected String suffix;
    /**
     * 基础包名
     */
    protected String packageName;

    /**
     * 对应的创建文件的集合
     */
//    protected ModuleTemplateType fileTypes[];

    @Override
    public IModuleInfo getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public String getPathFromTop() {
        // 父模块名/父模块名/子模块名；manage-data-storage / manage-data-storage-user
        return (parent == null ? "" : parent.getPathFromTop()) + FileHelper.FILE_SEPARATOR + getName();
    }

    @Override
    public String getAbsolutePath() {
        // base_path/manage-data-storage/manage-data-storage-user/src/main/java
        return FileHelper.BASE_PATH + getPathFromTop() + FileHelper.FILE_SEPARATOR + "src.main.java.".replaceAll("\\.", FileHelper.FILE_SEPARATOR);
    }

    @Override
    public String getOutDir() {
        // base_path/manage-data-storage/manage-data-storage-user/src/main/java/  com/feng/manage/storage(package)
        return getAbsolutePath() + (packageName == null ? "" : packageName).replaceAll("\\.", FileHelper.FILE_SEPARATOR);
    }
}
