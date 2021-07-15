package com.qianlingo.codegenerate.controller.sys.permission;

import com.qianlingo.codegenerate.common.constant.ApiConstant;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.service.sys.permission.ISysPermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单权限 路由控制层
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@RestController
@RequestMapping(ApiConstant.API_CONSTANT + "/sys/permission")
public class SysPermissionController {

    @Resource
    private ISysPermissionService iSysPermissionService;

    /**
     * 按用户编号获取用户所属角色包含的菜单资源
     * @return 用户所属角色包含的菜单资源
     */
    @PostMapping("getSysPermissionListDataByUserId")
    public AjaxJson getSysPermissionListDataByUserId(){
        return AjaxJson.getSuccess("success",this.iSysPermissionService.getSysPermissionListDataByUserId());
    }

    /**
     * 按用户编号获取用户所属角色包含的菜单资源，字符串数据，即按钮权限
     * @return 用户所属角色包含的菜单资源，字符串数据，即按钮权限
     */
    @PostMapping("getSysPermissionStringDataByUserId")
    public AjaxJson getSysPermissionStringDataByUserId(){
        return AjaxJson.getSuccess("success",this.iSysPermissionService.getSysPermissionStringDataByUserId());
    }

    /**
     * 按角色编号获取角色包含的菜单资源
     * @param roleId      角色编号
     * @return 角色包含的菜单资源
     */
    @PostMapping("getSysPermissionListDataByRoleId")
    public AjaxJson getSysPermissionListDataByRoleId(@RequestParam String roleId){
        return AjaxJson.getSuccess("success",this.iSysPermissionService.getSysPermissionListDataByRoleId(roleId));
    }

}
