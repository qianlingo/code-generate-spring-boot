package com.qianlingo.codegenerate.controller.system.login;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.ssh.Sftp;
import com.qianlingo.codegenerate.common.constant.ApiConstant;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.qianlingo.codegenerate.modules.mybatis.dto.system.login.SystemLoginDTO;
import com.qianlingo.codegenerate.modules.service.system.login.ISystemLoginService;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 登录操作 路由控制类
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
@RestController
@RequestMapping(ApiConstant.API_CONSTANT + "/system/login")
public class LoginController {

    @Resource
    private ISystemLoginService iSystemLoginService;

    /**
     * 登录操作
     * @param systemLoginDTO     登录数据表单
     * @return                   登录结果
     */
    @PostMapping("/loginAction")
    public AjaxJson loginAction(@RequestBody @Validated SystemLoginDTO systemLoginDTO){

        SysUser sysUser =  this.iSystemLoginService.loginAction(systemLoginDTO);

        StpUtil.login(sysUser.getId());

        SaTokenInfo token = StpUtil.getTokenInfo();

        StpUtil.getSession().set("onlineUser" , sysUser);

        return AjaxJson.getSuccess("success", token.getTokenValue());

    }

}
