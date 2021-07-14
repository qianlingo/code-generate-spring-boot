package com.qianlingo.codegenerate.modules.service.sys.user;

import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-14
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 按用户名称获取用户数据
     * @param userName  用户名称
     * @return          用户数据
     */
    SysUser getSysUserDataByUserName(String userName);

}
