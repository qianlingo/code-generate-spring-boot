package com.qianlingo.codegenerate.modules.mybatis.vo.sys.team;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目组 SearchVO
 * @author QianLinGooo
 * @since create in 2021/7/15
 */
@Data
public class SysTeamSearchVO {

    /**
     * 编号
     */
    private String id;

    /**
     * 项目小组名称
     */
    private String teamName;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态(0:禁用,1:启用)
     */
    private Integer status;

}
