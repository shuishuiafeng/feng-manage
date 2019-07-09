package com.feng.manage.common.result.enums;

/**
 * 异常码枚举。
 * 中二位为业务码，后二位为异常码。
 * 业务码：
 * member:1
 * quartz:2
 * report:3
 * reward:4
 * user:5
 * order:6
 *
 * @author Hanqi <jpanda@aliyun.com>
 * @since 2018/8/20 20:45
 */
public enum BusinessCode implements BaseBusinessExceptionCode {

    NULL_PARAMS(401, "参数缺失或不合法"),
    ROLE_EXCEPTION(402, "会员角色未维护"),
    USER_MUST_NOT_NULL(501, "用户数据不得为空"),
    USER_PASSWORD_OR_NAME_IS_ERR(502, "用户名或密码错误"),
    DATABASE_OPERATION_EXCEPTION(503, "数据库操作异常"),
    USER_AUTHENTICATION_FAIL(504, "用户权限不足"),
    MEMBER_UPLOAD_OSS_FILE_FAIL(505, "上传OSS文件异常"),
    JSON_PARSE_FAIL(506, "JSON转化异常");

    private Integer businessCode;
    private String message;

    BusinessCode(Integer businessCode, String message) {
        this.businessCode = businessCode;
        this.message = message;
    }

    @Override
    public Integer getBusinessCode() {
        return this.businessCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
