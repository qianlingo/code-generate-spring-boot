package com.qianlingo.codegenerate.modules.mybatis.dto.system.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 登录接口 DTO
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
@Data
public class SystemLoginDTO {

    /**
     * 用户名称
     */
    @NotEmpty(message = "用户名称不能为空！")
    @NotNull(message = "用户名称不能为空！")
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    /**
     * 用户密码
     */
    @NotEmpty(message = "密码不能为空！")
    @NotBlank(message = "密码不能为空")
    private String password;

}
