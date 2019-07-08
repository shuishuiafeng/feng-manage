package com.feng.manage.code.generator.ext.helps;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/8 15:42
 * @Description: 文件路径获取帮助类
 */
public final class FileHelper {

    private static final String LINUX_SEPARATOR = "/";
    private static final String WINDOWS_SEPARATOR = "\\";
    public static final String FILE_SEPARATOR;
    public static final String BASE_PATH;

    static {
        String realPath = ClassLoader.getSystemResource("").getPath();
        FILE_SEPARATOR = realPath.contains(LINUX_SEPARATOR) ? LINUX_SEPARATOR : WINDOWS_SEPARATOR;
        realPath = realPath.substring(realPath.startsWith(FILE_SEPARATOR) ? 1 : 0);


        int count = 5;
        while (count > 0) {
            realPath = realPath.substring(0, realPath.lastIndexOf(FILE_SEPARATOR));
            count--;
        }
        BASE_PATH = realPath;
    }

}
