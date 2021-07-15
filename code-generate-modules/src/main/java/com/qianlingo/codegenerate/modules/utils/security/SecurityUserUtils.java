package com.qianlingo.codegenerate.modules.utils.security;

import cn.dev33.satoken.stp.StpUtil;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;

/**
 * 安全框架 用户工具类
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
public class SecurityUserUtils {

    /**
     * 获取当前session用户
     * @return      当前session用户
     */
    public static SysUser getUserData(){
        return (SysUser) StpUtil.getSession().get("onlineUser");
    }

    /**
     * 获取当前用户编号
     * @return
     */
    public static String getUserId(){ return getUserData().getId();}

}
