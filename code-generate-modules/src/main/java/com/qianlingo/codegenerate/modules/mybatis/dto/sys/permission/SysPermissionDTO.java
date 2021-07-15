package com.qianlingo.codegenerate.modules.mybatis.dto.sys.permission;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限 DTO
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysPermissionDTO extends Page<SysPermissionDTO> {

    /**
     * 角色编号
     */
    private String roleId;

}
