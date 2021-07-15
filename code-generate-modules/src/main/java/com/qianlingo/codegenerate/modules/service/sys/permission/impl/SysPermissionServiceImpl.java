package com.qianlingo.codegenerate.modules.service.sys.permission.impl;

import com.qianlingo.codegenerate.modules.mybatis.domain.sys.permission.SysPermission;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.permission.SysPermissionDTO;
import com.qianlingo.codegenerate.modules.mybatis.mapper.sys.permission.SysPermissionMapper;
import com.qianlingo.codegenerate.modules.mybatis.vo.sys.permission.SysPermissionVO;
import com.qianlingo.codegenerate.modules.service.sys.permission.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlingo.codegenerate.modules.utils.security.SecurityUserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    /**
     * 按用户编号获取用户所属角色包含的菜单资源
     *
     * @return 用户所属角色包含的菜单资源
     */
    @Override
    public List<SysPermissionVO> getSysPermissionListDataByUserId() {
        String userId = SecurityUserUtils.getUserId();
        return this.baseMapper.getSysPermissionListDataByUserId(userId);
    }

    /**
     * 按用户编号获取用户所属角色包含的菜单资源，字符串数据，即按钮权限
     *
     * @return 用户所属角色包含的菜单资源，字符串数据，即按钮权限
     */
    @Override
    public List<String> getSysPermissionStringDataByUserId() {
        String userId = SecurityUserUtils.getUserId();
        return this.baseMapper.getSysPermissionStringDataByUserId(userId);
    }

    /**
     * 按角色编号获取角色包含的菜单资源
     * @param roleId    角色编号
     * @return 角色包含的菜单资源
     */
    @Override
    public List<SysPermissionVO> getSysPermissionListDataByRoleId(String roleId) {
        return this.baseMapper.getSysPermissionListDataByRoleId(roleId);
    }
}
