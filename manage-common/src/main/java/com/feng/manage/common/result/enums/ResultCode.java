package com.feng.manage.common.result.enums;


/**
 * 业务状态返回码.
 * 状态码依照HTTP状态码来实现。
 *
 * @author Hanqi <jpanda@aliyun.com>
 * @since 2018/8/9 14:58
 */
public enum ResultCode {
    /**
     * 请求已成功，请求所希望的响应头或数据体将随此响应返回。
     */
    SUCCESS(200, "请求已成功，请求所希望的响应头或数据体将随此响应返回。"),
    /**
     * 请求已接收，但尚未处理。
     * 例如：通过MQ完成后续操作，或异步完成操作。
     */
    WAIT_EXECUTE(202, "请求已接收，但尚未处理。"),
    /**
     * 请求已被处理，但无返回内容。
     */
    EMPTY_BODY(204, "请求已被处理，但无返回内容。"),
    /**
     * 请求语义有误
     * 例如:构造的请求不符合规范
     */
    INVALID_REQUEST(400, "请求语义有误。"),
    /**
     * 当前请求需要用户验证
     */
    AUTHORIZATION(401, "当前请求需要用户验证"),
    /**
     * 拒绝提供服务
     * 比如，当熔断打开时可以返回该CODE，只是不够友好。更推荐使用
     *
     * @see ResultCode#TEMP_REFUSE_SERVICE
     */
    REFUSE_SERVICE(403, "拒绝提供服务"),
    /**
     * 无对应的服务
     * 例如: 加载或请求了不存在的资源
     */
    NOT_FOUND(404, "无对应的服务"),
    /**
     * 请求与已有资源冲突
     * 比如:多次使用同一数据注册。
     */
    CONFLICT_SERVICE(409, "请求与已有资源冲突"),
    /**
     * 服务器内部错误
     * 例如:提供业务时代码发生错误。
     */
    SERVER_EXCEPTION(500, "服务器内部错误"),
    /**
     * 服务器暂时无法提供服务
     * 比如，当熔断打开时可以返回该CODE
     */
    TEMP_REFUSE_SERVICE(503, "服务器暂时无法提供服务。");


    /**
     * 服务状态返回编码。
     */
    private Integer code;
    /**
     * 服务状态编码描述
     */
    private String codeDescription;

    ResultCode(Integer code, String codeDescription) {
        this.code = code;
        this.codeDescription = codeDescription;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getCodeDescription() {
        return this.codeDescription;
    }
}
