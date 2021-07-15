package com.qianlingo.codegenerate.controller.sys.user;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.qianlingo.codegenerate.common.constant.ApiConstant;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.qianlingo.codegenerate.modules.service.sys.user.ISysUserService;
import com.qianlingo.codegenerate.modules.utils.security.SecurityUserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户 路由控制类
 *
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@RestController
@RequestMapping(ApiConstant.API_CONSTANT + "/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 获取用户信息
     * @return      用户信息
     */
    @SaCheckPermission("user:get")
    @RequestMapping("/getSysUserData")
    public AjaxJson getSysUserData(){
        List<SysUser> sysUsers = this.iSysUserService.list();
        return AjaxJson.getPageData((long) sysUsers.size(), sysUsers);
    }

}
