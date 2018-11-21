package com.ykl.demo.common;

public enum  ResultCode {
	
    SUCCESS(200, "处理成功"),
    UNAUTHTOKEN(402, "登入失效，请重新登入！"),
    NOT_FOUND(404, "很抱歉你访问的地址不存在！"),
    NOT_SUPPORTED(405, "请求方式错误"),
    INTERNAL_SERVER_ERROR(500, "系统繁忙，请稍后再试！"),
    
    SIGN_ERROR(10000, "签名有误"),
    PARAMETER_ERROR(10001, "参数有误"),
    IS_MOBILE_ERROR(10002, "手机号格式不对"),
    VERIFY_CODE_ERROR(10003, "验证码有误"),
    USERNAME_OR_PASSWORD_ERROR(10004, "用户名或密码错误"),
    USERNAME_IS_EXIST_ERROR(10005, "用户名已存在");
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
