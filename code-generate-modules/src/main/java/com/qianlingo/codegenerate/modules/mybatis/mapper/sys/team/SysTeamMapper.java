package com.qianlingo.codegenerate.modules.mybatis.mapper.sys.team;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.team.SysTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.team.SysTeamSearchDTO;
import com.qianlingo.codegenerate.modules.mybatis.vo.sys.team.SysTeamSearchVO;

/**
 * <p>
 * 项目组表 Mapper 接口
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
public interface SysTeamMapper extends BaseMapper<SysTeam> {


    /**
     * 获取项目组数据，含分页
     * @param sysTeamSearchVO   查询条件
     * @return                  项目组数据，含分页
     */
    Page<SysTeamSearchVO> getSysTeamPageData(SysTeamSearchDTO sysTeamSearchVO);

}
