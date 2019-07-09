package com.feng.manage.common.result.helper;

import com.feng.manage.common.exception.BusinessRuntimeException;
import com.feng.manage.common.result.Result;
import com.feng.manage.common.result.enums.BaseBusinessExceptionCode;
import com.feng.manage.common.result.enums.ResultCode;

import java.util.Objects;

import static com.feng.manage.common.utils.ResultUtils.DEFAULT_BUSINESS_CODE;
import static com.feng.manage.common.utils.ResultUtils.isSuccess;


/**
 * 返回结果构造工具类
 *
 * @author Hanqi <jpanda@aliyun.com>
 * @since 2018/8/9 17:52
 */
public final class ResultHelper {
    /**
     * 统一构造失败响应内容
     *
     * @param <T> 响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail() {
        return buildFail(null);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param <T> 响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildSuccess() {
        return buildSuccess(null);
    }


    /**
     * 统一构造失败响应内容
     *
     * @param businessExceptionCode 异常码
     * @param body                  异常内容
     * @param <T>                   异常实体类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail(BaseBusinessExceptionCode businessExceptionCode, T body) {
        return buildFail(ResultCode.SERVER_EXCEPTION, businessExceptionCode, body);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode            响应码
     * @param businessExceptionCode 异常码
     * @param body                  异常内容
     * @param <T>                   异常实体类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail(ResultCode resultCode, BaseBusinessExceptionCode businessExceptionCode, T body) {
        return buildFail(resultCode.getCode(), businessExceptionCode.getBusinessCode(), businessExceptionCode.getMessage(), body);
    }


    /**
     * 统一构造失败响应内容
     *
     * @param body 响应结果
     * @param <T>  响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail(T body) {
        return autoBuild(ResultCode.SERVER_EXCEPTION, body);
    }

    /**
     * 根据异常返回失败响应信息
     *
     * @param be
     * @return
     */
    public static Result buildException(BusinessRuntimeException be) {
        Result result = buildFail();
        result.setMessage(be.getMessage());
        result.setBusinessCode(be.getBusinessCode());
        if (!Objects.isNull(be.getBusinessExceptionCode())) {
            BaseBusinessExceptionCode businessExceptionCode = be.getBusinessExceptionCode();
            if (!Objects.isNull(businessExceptionCode.getMessage())) {
                result.setMessage(businessExceptionCode.getMessage());
            }
            if (!Objects.isNull(businessExceptionCode.getBusinessCode())) {
                result.setBusinessCode(businessExceptionCode.getBusinessCode());
            }
        }
        return result;
    }

    /**
     * 统一构造失败响应内容
     *
     * @param body 响应结果
     * @param <T>  响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildSuccess(T body) {
        return autoBuild(ResultCode.SUCCESS, body);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode 请求状态响应主码以及请求响应消息
     * @param <T>        响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> autoBuild(ResultCode resultCode) {
        return autoBuild(resultCode, null);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode 请求状态响应主码以及请求响应消息
     * @param body       响应结果
     * @param <T>        响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> autoBuild(ResultCode resultCode, T body) {
        return build(isSuccess(resultCode.getCode()), resultCode.getCode(), DEFAULT_BUSINESS_CODE, resultCode.getCodeDescription(), body);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode   请求状态响应主码以及请求响应消息
     * @param businessCode 业务级响应子码
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> autoBuild(ResultCode resultCode, Integer businessCode, T body) {
        return build(isSuccess(resultCode.getCode()), resultCode.getCode(), businessCode, resultCode.getCodeDescription(), body);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode   请求状态响应主码以及请求响应消息
     * @param businessCode 业务级响应子码
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildSuccess(ResultCode resultCode, Integer businessCode, T body) {
        return buildSuccess(resultCode.getCode(), businessCode, resultCode.getCodeDescription(), body);
    }

    /**
     * 统一构造失败响应内容
     *
     * @param resultCode   请求状态响应主码以及请求响应消息
     * @param businessCode 业务级响应子码
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail(ResultCode resultCode, Integer businessCode, T body) {
        return buildFail(resultCode.getCode(), businessCode, resultCode.getCodeDescription(), body);
    }

    /**
     * 统一构造处理成功的响应内容
     *
     * @param code         请求状态响应主码
     * @param businessCode 业务级响应子码
     * @param message      响应消息
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildSuccess(Integer code, Integer businessCode, String message, T body) {
        return new Result<>(Boolean.TRUE, code, businessCode, message, body);
    }

    /**
     * 统一构造处理失败的响应内容
     *
     * @param code         请求状态响应主码
     * @param businessCode 业务级响应子码
     * @param message      响应消息
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> buildFail(Integer code, Integer businessCode, String message, T body) {
        return new Result<>(Boolean.FALSE, code, businessCode, message, body);
    }

    /**
     * 统一构造响应内容
     *
     * @param success      请求是否执行成功
     * @param code         请求状态响应主码
     * @param businessCode 业务级响应子码
     * @param message      响应消息
     * @param body         响应结果
     * @param <T>          响应结果类型
     * @return 统一构造的响应内容
     */
    public static <T> Result<T> build(Boolean success, Integer code, Integer businessCode, String message, T body) {
        return new Result<>(success, code, businessCode, message, body);
    }
}
