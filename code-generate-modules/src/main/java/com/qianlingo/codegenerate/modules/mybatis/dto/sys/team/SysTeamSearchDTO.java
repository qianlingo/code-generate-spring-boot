package com.qianlingo.codegenerate.modules.mybatis.dto.sys.team;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目组 SearchDTO
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SysTeamSearchDTO extends Page<SysTeamSearchDTO> {

    /**
     * 编号
     */
    private String id;

    /**
     * 项目组名称
     */
    private String teamName;

}
