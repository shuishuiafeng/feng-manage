package com.feng.manage.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 14:33
 * @Description: 微服务统一返回结构体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 请求是否处理成功
     *
     * @since 2018/8/9 14:47
     */
    private Boolean success;
    /**
     * 请求相应状态码
     *
     *
     */
    private Integer code;
    /**
     * 具体业务状态码
     * 该状态码由具体的微服务处理。
     */
    private Integer businessCode;
    /**
     * 提示消息
     */
    private String message;

    /**
     * 相应结果
     */
    private T body;

    public Result(Result<T> result) {
        this.setSuccess(result.getSuccess());
        this.setCode(result.getCode());
        this.setBusinessCode(result.getBusinessCode());
        this.setMessage(result.getMessage());
        this.setBody(result.getBody());
    }

    /**
     * 浅copy
     *
     * @return 当前返回对象的浅copy
     */
    public Result<T> copy() {

        return new Result<>(this);
    }
}
