package com.feng.manage.code.generator;

import com.feng.manage.code.generator.ext.AutoGeneratorCaller;
import com.feng.manage.code.generator.ext.items.ItemEnum;
import com.feng.manage.code.generator.ext.names.SystemAuthNameGeneration;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 11:33
 * @Description: 代码生成器
 */
public class CodeGenerator {

    private static ItemEnum item = ItemEnum.USER;

    /**
     * 作者
     */
    public static final String AUTH_NAME = new SystemAuthNameGeneration().name();

    public static void main(String[] args) {
        AutoGeneratorCaller.doExec(AUTH_NAME, item, "t_permission");
    }

}
