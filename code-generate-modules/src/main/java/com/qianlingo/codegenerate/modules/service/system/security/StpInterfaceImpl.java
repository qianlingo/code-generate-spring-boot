package com.qianlingo.codegenerate.modules.service.system.security;

import java.util.ArrayList;
import java.util.List;

import com.qianlingo.codegenerate.modules.service.sys.permission.ISysPermissionService;
import org.springframework.stereotype.Component;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 自定义权限验证接口扩展
 * @author QianLinGooo
 * @since create in 2021/07/15
 */
@Component	// 打开此注解，保证此类被springboot扫描，即可完成sa-token的自定义权限验证扩展 
public class StpInterfaceImpl implements StpInterface {

	@Resource
	private ISysPermissionService iSysPermissionService;

	/**
	 * 返回一个账号所拥有的权限码集合 
	 */
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		return this.iSysPermissionService.getSysPermissionStringDataByUserId();
	}

	/**
	 * 返回一个账号所拥有的角色标识集合 
	 */
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		// 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
		List<String> list = new ArrayList<String>();	
		list.add("admin");
		list.add("super-admin");
		return list;
	}

}
