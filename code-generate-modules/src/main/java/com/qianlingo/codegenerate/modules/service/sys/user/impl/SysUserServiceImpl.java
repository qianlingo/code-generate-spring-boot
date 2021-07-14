package com.qianlingo.codegenerate.modules.service.sys.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.user.SysUser;
import com.qianlingo.codegenerate.modules.mybatis.mapper.sys.user.SysUserMapper;
import com.qianlingo.codegenerate.modules.service.sys.user.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    /**
     * 按用户名称获取用户数据
     * @param userName  用户名称
     * @return          用户数据
     */
    @Override
    public SysUser getSysUserDataByUserName(String userName) {
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("user_name",userName);
        return this.getOne(sysUserQueryWrapper);
    }
}
