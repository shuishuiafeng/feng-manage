package com.feng.manage.code.generator.ext;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.feng.manage.code.generator.ext.items.IItem;
import com.feng.manage.code.generator.ext.items.ItemEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:02
 * @Description: 自定义继承于AutoGenerator的代码生成器
 */
public class FengManageAutoGenerator extends AutoGenerator {

    private static final Logger logger = LoggerFactory.getLogger(AutoGenerator.class);
    /**
     * 配置信息
     */
    protected ConfigBuilder config;
    /**
     * 注入配置
     */
    protected InjectionConfig injectionConfig;
    /**
     * 数据源配置
     */
    private DataSourceConfig dataSource;
    /**
     * 数据库表配置
     */
    private StrategyConfig strategy;
    /**
     * 包 相关配置
     */
    private PackageConfig packageInfo;
    /**
     * 模板 相关配置
     */
    private TemplateConfig template;
    /**
     * 全局 相关配置
     */
    private GlobalConfig globalConfig;
    /**
     * 模板引擎
     */
    private AbstractTemplateEngine templateEngine;

    // ext
    private ItemEnum item;

    public FengManageAutoGenerator(ItemEnum item) {
        this.item = item;
    }

    @Override
    public void execute() {
        logger.debug("==========================准备生成文件...==========================");
        // 初始化配置
        if (null == config) {
            config = new ConfigBuilder(packageInfo, dataSource, strategy, template, globalConfig);
            afterProcessPackageInfo(config.getPackageInfo(), config.getPathInfo());
            if (null != injectionConfig) {
                injectionConfig.setConfig(config);
            }
        }
        if (null == templateEngine) {
            // 为了兼容之前逻辑，采用 Velocity 引擎 【 默认 】
//            templateEngine = new CustomerVelocityTemplateEngine();
            templateEngine = new VelocityTemplateEngine();
        }
        // 模板引擎初始化执行文件输出
        templateEngine.init(this.pretreatmentConfigBuilder(config)).mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");
    }

    // ext 后续处理包信息和路径信息
    protected void afterProcessPackageInfo(Map<String, String> packageInfo, Map<String, String> pathInfo) {
        packageInfo.put(ConstVal.MODULENAME, item.name());
        IItem itemLocal = item.getItem();
        packageInfo.put(ConstVal.ENTITY, joinPackage(itemLocal.getEntity().getModuleInfo().getPackageName(), itemLocal.getEntity().getTemplate().getPackageName()));
        packageInfo.put(ConstVal.MAPPER, joinPackage(itemLocal.getMapper().getModuleInfo().getPackageName(), itemLocal.getMapper().getTemplate().getPackageName()));
        packageInfo.put(ConstVal.XML, joinPackage(itemLocal.getMapperXml().getModuleInfo().getPackageName(), itemLocal.getMapperXml().getTemplate().getPackageName()));
        packageInfo.put(ConstVal.SERVICE, joinPackage(itemLocal.getService().getModuleInfo().getPackageName(), itemLocal.getService().getTemplate().getPackageName()));
        packageInfo.put(ConstVal.SERVICEIMPL, joinPackage(itemLocal.getServiceImpl().getModuleInfo().getPackageName(), itemLocal.getServiceImpl().getTemplate().getPackageName()));
        packageInfo.put(ConstVal.CONTROLLER, joinPackage(itemLocal.getController().getModuleInfo().getPackageName(), itemLocal.getController().getTemplate().getPackageName()));

        // 生成路径信息
        if (StringUtils.isNotEmpty(template.getEntity(getGlobalConfig().isKotlin()))) {
            pathInfo.put(ConstVal.ENTITY_PATH, joinPath(itemLocal.getEntity().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.ENTITY)));
        }
        if (StringUtils.isNotEmpty(template.getMapper())) {
            pathInfo.put(ConstVal.MAPPER_PATH, joinPath(itemLocal.getMapper().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.MAPPER)));
        }
        if (StringUtils.isNotEmpty(template.getXml())) {
            pathInfo.put(ConstVal.XML_PATH, joinPath(itemLocal.getMapperXml().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.XML)));
        }
        if (StringUtils.isNotEmpty(template.getService())) {
            pathInfo.put(ConstVal.SERVICE_PATH, joinPath(itemLocal.getService().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.SERVICE)));
        }
        if (StringUtils.isNotEmpty(template.getServiceImpl())) {
            pathInfo.put(ConstVal.SERVICEIMPL_PATH, joinPath(itemLocal.getServiceImpl().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.SERVICEIMPL)));
        }
        if (StringUtils.isNotEmpty(template.getController())) {
            pathInfo.put(ConstVal.CONTROLLER_PATH, joinPath(itemLocal.getController().getModuleInfo().getAbsolutePath(), packageInfo.get(ConstVal.CONTROLLER)));
        }
    }

    private String joinPath(String parentDir, String packageName) {
        if (StringUtils.isEmpty(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", "\\" + File.separator);
        return parentDir + packageName;
    }

    private String joinPackage(String parent, String subPackage) {
        if (StringUtils.isEmpty(parent)) {
            return subPackage;
        }
        return parent + "." + subPackage;
    }
}
