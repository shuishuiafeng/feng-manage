package com.feng.manage.common.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 构建请求结果需要使用的工具类
 *
 * @author Hanqi <jpanda@aliyun.com>
 * @since 2018/8/9 17:50
 */
public final class ResultUtils {
    /**
     * 标志成功的返回状态码集合
     */
    private final static List<Integer> SUCCESS_CODE = Arrays.asList(200, 202, 204);
    /**
     * 默认的业务级别状态码
     */
    public final static Integer DEFAULT_BUSINESS_CODE = 0;
    /**
     * 空对象
     */
    public final static Object EMPTY_OBJECT = null;
    /**
     * 默认的提示消息
     */
    public final static String DEFAULT_MESSAGE = "";

    /**
     * 验证指定的状态码是否为成功
     *
     * @param code 响应状态码
     * @return 是否成功响应
     */
    public static Boolean isSuccess(Integer code) {
        return SUCCESS_CODE.contains(code);
    }

}
