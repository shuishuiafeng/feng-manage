package com.feng.manage.code.generator.ext.names;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 16:48
 * @Description: 代码生成作者
 */
public class SystemAuthNameGeneration implements IAuthNameGenerator{

    @Override
    public String name() {
        String userName = System.getProperty("user.name");
        if (null == userName || userName.isEmpty()) {
            userName = "admin";
        }
        return userName;
    }

}
