package com.hww.common.exception;


/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/21-0:45
 * @Description:
 */
public enum BizCodeEnum {

    UNKNOWN_EXCEPTION(10000, "系统位置错误"),
    VALIDATEEXCEPTION(10001, "数据校验失败");

    private Integer code;
    private String message;

    BizCodeEnum( Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
