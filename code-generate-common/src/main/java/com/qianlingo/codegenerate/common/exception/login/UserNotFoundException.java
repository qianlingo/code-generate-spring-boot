package com.qianlingo.codegenerate.common.exception.login;

/**
 * 用户不存在错误异常
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("用户数据不存在，请确认信息或注册！");
    }
}
