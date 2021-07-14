package com.qianlingo.codegenerate.modules.service.system.login.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import com.qianlingo.codegenerate.common.exception.login.UserNameOrPasswordErrorException;
import com.qianlingo.codegenerate.common.exception.login.UserNotFoundException;
import com.qianlingo.codegenerate.common.exception.login.UserStatusErrorException;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.qianlingo.codegenerate.modules.mybatis.dto.system.login.SystemLoginDTO;
import com.qianlingo.codegenerate.modules.service.sys.user.ISysUserService;
import com.qianlingo.codegenerate.modules.service.system.login.ISystemLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录操作 Service - Impl
 *
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
@Service
public class SystemLoginServiceImpl implements ISystemLoginService {

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 登录操作
     *
     * @param systemLoginDTO 登录请求数据
     * @return 登录结果
     */
    @Override
    public SysUser loginAction(SystemLoginDTO systemLoginDTO) {
        SysUser sysUser = this.iSysUserService.getSysUserDataByUserName(systemLoginDTO.getUserName());
        if(null == sysUser){
            throw new UserNotFoundException();
        }
        if(!sysUser.getStatus()){
            throw new UserStatusErrorException();
        }
        String inputMd5Password = DigestUtil.md5Hex(String.format("QL-%s-%s"
                , systemLoginDTO.getUserName()
                ,systemLoginDTO.getPassword()));
        if(!inputMd5Password.equals(sysUser.getPassword())){
            throw new UserNameOrPasswordErrorException();
        }
        return sysUser;
    }

}
