package com.feng.manage.common.exception;

import com.feng.manage.common.result.enums.BaseBusinessExceptionCode;
import com.feng.manage.common.result.enums.ResultCode;

/***
 * 统一业务级异常
 */
public class BusinessRuntimeException extends RuntimeException {
    /**
     * HTTP 返回状态码
     */
    private Integer code;
    /**
     * 业务 状态码
     */
    private Integer businessCode;

    private BaseBusinessExceptionCode businessExceptionCode;

    public BusinessRuntimeException(BaseBusinessExceptionCode code) {
        super(code.getMessage());
        this.businessExceptionCode = code;
        this.code = ResultCode.SERVER_EXCEPTION.getCode();
        this.businessCode = code.getBusinessCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Integer businessCode) {
        this.businessCode = businessCode;
    }

    public BaseBusinessExceptionCode getBusinessExceptionCode() {
        return businessExceptionCode;
    }
}
