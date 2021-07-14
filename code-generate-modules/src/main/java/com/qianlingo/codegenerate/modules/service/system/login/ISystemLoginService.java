package com.qianlingo.codegenerate.modules.service.system.login;

import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.qianlingo.codegenerate.modules.mybatis.dto.system.login.SystemLoginDTO;

/**
 * 登录操作 Service
 *
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
public interface ISystemLoginService {

    /**
     * 登录操作
     * @param systemLoginDTO    登录请求数据
     * @return                  登录结果
     */
    SysUser loginAction(SystemLoginDTO systemLoginDTO);

}
