package com.feng.manage.common.exception.enums;

/**
 * 业务返回状态码接口
 *
 * @author Hanqi <jpanda@aliyun.com>
 * @since 2018/8/13 17:30
 */
public interface BaseBusinessExceptionCode {
    /**
     *  获取业务异常码
     * @return 业务异常码
     */
    Integer getBusinessCode();

    /**
     * 获取异常信息
     * @return 业务异常码
     */
    String getMessage();
}
