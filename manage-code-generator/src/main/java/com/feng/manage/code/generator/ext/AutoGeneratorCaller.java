package com.feng.manage.code.generator.ext;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.feng.manage.code.generator.ext.items.ItemEnum;
import com.feng.manage.code.generator.ext.modules.ModuleInfoEnum;
import com.feng.manage.code.generator.ext.modules.ModuleInfoTemplateTypeEnum;
import com.feng.manage.code.generator.ext.names.SystemAuthNameGeneration;
import com.mysql.jdbc.Driver;
import org.springframework.lang.Nullable;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:49
 * @Description: 自动生成代码调用类
 */
public class AutoGeneratorCaller {
    /**
     * 作者
     */
    public static String AUTH_NAME;
    /**
     * 需要生成的表名称
     */
    public static String[] TABLES = new String[]{""};

    public static final String DB_URL = "jdbc:mysql://192.168.1.138:3306/hh_xds?useSSL=false";
    public static final String DB_USERNAME = "mysql";
    public static final String DB_PWD = "31415926";
    public static final String DB_DRIVER = Driver.class.getName();

    public static void doExec(@Nullable String authName, ItemEnum itemEnum, String... tables) {
        if (authName == null || authName.isEmpty()) {
            authName = new SystemAuthNameGeneration().name();
        }
        AUTH_NAME = authName;
        TABLES = tables;
        //  获取全局配置模板
        GlobalConfig config = getGlobalConfig();

        // 获取数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 获取具体的文件内策略配置
        StrategyConfig strategyConfig = getStrategyConfig();

        // 包配置
        PackageConfig packageConfig = getPackageConfig();
        TemplateConfig templateConfig = getTemplateConfig();
        new FengManageAutoGenerator(itemEnum)
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .execute();
    }

    public static void doExec(ItemEnum itemEnum, String... tables) {
        doExec(null, itemEnum, tables);
    }


    /**
     * 自动配置代码生成模板,只保留对应的模板文件
     *
     * @return 模板配置
     * @author Hanqi <jpanda@aliyun.com>
     * @since 2018/8/14 16:32
     */
    public static TemplateConfig getTemplateConfig() {
        return new TemplateConfig();
    }

    /**
     * 生成策略 比较重要
     *
     * @return 策略
     */
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel).setInclude(TABLES)
                .setRestControllerStyle(true)
        ;
        return strategyConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(DB_URL)
                .setUsername(DB_USERNAME)
                .setPassword(DB_PWD)
                .setDriverName(DB_DRIVER);
        return dataSourceConfig;
    }

    private static GlobalConfig getGlobalConfig() {
        // 获取文件的输出目录

        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setEnableCache(false)
                .setAuthor(AUTH_NAME)
                .setOutputDir(ModuleInfoEnum.SERVER_USER.getModuleInfo().getOutDir())
                .setFileOverride(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
        ;
        return config;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(ModuleInfoEnum.SERVER_USER.getModuleInfo().getPackageName());
        packageConfig.setController(ModuleInfoTemplateTypeEnum.CONTROLLER.getPackageName());
        packageConfig.setService(ModuleInfoTemplateTypeEnum.SERVICE.getPackageName());
        packageConfig.setServiceImpl(ModuleInfoTemplateTypeEnum.SERVICE_IMPL.getPackageName());
        packageConfig.setMapper(ModuleInfoTemplateTypeEnum.MAPPER.getPackageName());
        packageConfig.setXml(ModuleInfoTemplateTypeEnum.MAPPER_XML.getPackageName());
        packageConfig.setEntity(ModuleInfoTemplateTypeEnum.PO.getPackageName());
        return packageConfig;
    }
}
