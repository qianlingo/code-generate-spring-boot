package com.qianlingo.codegenerate.handler;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.hutool.crypto.digest.DigestUtil;
import com.qianlingo.codegenerate.common.exception.login.UserNameOrPasswordErrorException;
import com.qianlingo.codegenerate.common.exception.login.UserNotFoundException;
import com.qianlingo.codegenerate.common.exception.login.UserStatusErrorException;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 错误类全局注解
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
@ControllerAdvice
public class LoginHandler {

    /**
     * 绑定类异常
     * @param e 错误异常
     * @return  返回消息
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxJson bindException(BindException e) {
        return AjaxJson.getError("请求缺少必要的参数!");
    }

    /**
     * 绑定类异常
     * @param e 错误异常
     * @return  返回消息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxJson bindException(MethodArgumentNotValidException e) {
        return AjaxJson.getError("请求缺少必要的参数!");
    }

    /**
     * 用户状态错误异常
     * @param e     错误异常
     * @return      返回消息
     */
    @ExceptionHandler(UserStatusErrorException.class)
    @ResponseBody
    public AjaxJson bindException(UserStatusErrorException e) {
        return AjaxJson.getError(e.getMessage());
    }

    /**
     * 用户状态错误异常
     * @param e     错误异常
     * @return      返回消息
     */
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public AjaxJson bindException(UserNotFoundException e) {
        return AjaxJson.getError(e.getMessage());
    }

    /**
     * 用户 用户名或密码错误异常
     * @param e     错误异常
     * @return      返回消息
     */
    @ExceptionHandler(UserNameOrPasswordErrorException.class)
    @ResponseBody
    public AjaxJson bindException(UserNameOrPasswordErrorException e) {
        return AjaxJson.getError(e.getMessage());
    }

    /**
     * 用户 用户名或密码错误异常
     * @param e     错误异常
     * @return      返回消息
     */
    @ExceptionHandler(NotPermissionException.class)
    @ResponseBody
    public AjaxJson notPermissionException(NotPermissionException e) {
        return AjaxJson.getError("无权限的请求！");
    }

}
