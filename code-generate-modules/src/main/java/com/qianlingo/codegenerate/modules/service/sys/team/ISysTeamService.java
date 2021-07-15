package com.qianlingo.codegenerate.modules.service.sys.team;

import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.team.SysTeam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.team.SysTeamSearchDTO;
import com.qianlingo.codegenerate.modules.mybatis.vo.sys.team.SysTeamSearchVO;

import java.util.List;

/**
 * <p>
 * 项目组表 服务类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
public interface ISysTeamService extends IService<SysTeam> {

    /**
     * 获取项目组数据，含分页
     * @param sysTeamSearchDTO   查询条件
     * @return                  项目组数据，含分页
     */
    AjaxJson getSysTeamPageData(SysTeamSearchDTO sysTeamSearchDTO);

}
