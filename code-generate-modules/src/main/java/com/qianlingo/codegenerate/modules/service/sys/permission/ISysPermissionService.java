package com.qianlingo.codegenerate.modules.service.sys.permission;

import com.qianlingo.codegenerate.modules.mybatis.domain.sys.permission.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.permission.SysPermissionDTO;
import com.qianlingo.codegenerate.modules.mybatis.vo.sys.permission.SysPermissionVO;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
public interface ISysPermissionService extends IService<SysPermission> {

    /**
     * 按用户编号获取用户所属角色包含的菜单资源
     * @return 用户所属角色包含的菜单资源
     */
    List<SysPermissionVO> getSysPermissionListDataByUserId();

    /**
     * 按用户编号获取用户所属角色包含的菜单资源，字符串数据，即按钮权限
     * @return 用户所属角色包含的菜单资源，字符串数据，即按钮权限
     */
    List<String> getSysPermissionStringDataByUserId();

    /**
     * 按角色编号获取角色包含的菜单资源
     * @param roleId      角色编号
     * @return 角色包含的菜单资源
     */
    List<SysPermissionVO> getSysPermissionListDataByRoleId(String roleId);

}
