package com.qianlingo.codegenerate.controller.sys.team;

import com.qianlingo.codegenerate.common.constant.ApiConstant;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.team.SysTeamSearchDTO;
import com.qianlingo.codegenerate.modules.service.sys.team.ISysTeamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目组 路由控制类
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@RestController
@RequestMapping(ApiConstant.API_CONSTANT + "/sys/team")
public class SysTeamController {

    @Resource
    private ISysTeamService iSysTeamService;

    /**
     * 获取项目组数据，含分页
     * @param sysTeamSearchDTO 查询条件
     * @return 项目组数据，含分页
     */
    @PostMapping("/getSysTeamPageData")
    public AjaxJson getSysTeamPageData(@RequestBody SysTeamSearchDTO sysTeamSearchDTO){
        return this.iSysTeamService.getSysTeamPageData(sysTeamSearchDTO);
    }

}
