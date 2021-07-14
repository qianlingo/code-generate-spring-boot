package com.qianlingo.codegenerate.common.exception.login;

/**
 * 用户状态错误异常
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
public class UserStatusErrorException extends RuntimeException {

    public UserStatusErrorException() {
        super("当前账户已被禁用");
    }
}
