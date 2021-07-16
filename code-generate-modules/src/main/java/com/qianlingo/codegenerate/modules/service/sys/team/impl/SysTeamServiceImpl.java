package com.qianlingo.codegenerate.modules.service.sys.team.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlingo.codegenerate.common.satoken.utils.AjaxJson;
import com.qianlingo.codegenerate.modules.mybatis.domain.sys.team.SysTeam;
import com.qianlingo.codegenerate.modules.mybatis.dto.sys.team.SysTeamSearchDTO;
import com.qianlingo.codegenerate.modules.mybatis.mapper.sys.team.SysTeamMapper;
import com.qianlingo.codegenerate.modules.mybatis.vo.sys.team.SysTeamSearchVO;
import com.qianlingo.codegenerate.modules.service.sys.team.ISysTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目组表 服务实现类
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
@Service
public class SysTeamServiceImpl extends ServiceImpl<SysTeamMapper, SysTeam> implements ISysTeamService {

    /**
     * 获取项目组数据，含分页
     * @param sysTeamSearchDTO 查询条件
     * @return 项目组数据，含分页
     */
    @Override
    public AjaxJson getSysTeamPageData(SysTeamSearchDTO sysTeamSearchDTO) {
        Page<SysTeamSearchVO> sysTeamPageData = this.baseMapper.getSysTeamPageData(sysTeamSearchDTO);
        return AjaxJson.getSuccess(AjaxJson.CODE_SUCCESS_MESSAGE , sysTeamPageData);
    }
}
