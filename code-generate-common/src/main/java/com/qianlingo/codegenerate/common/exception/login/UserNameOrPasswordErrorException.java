package com.qianlingo.codegenerate.common.exception.login;

/**
 * 用户 用户名或密码错误异常
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
public class UserNameOrPasswordErrorException extends RuntimeException {

    public UserNameOrPasswordErrorException() {
        super("用户名或密码不正确！");
    }
}
