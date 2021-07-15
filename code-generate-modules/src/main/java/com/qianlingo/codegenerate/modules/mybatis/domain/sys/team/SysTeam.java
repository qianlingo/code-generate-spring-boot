package com.qianlingo.codegenerate.modules.mybatis.domain.sys.team;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 项目组表
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysTeam implements Serializable {

    private static final long serialVersionUID = 1L;

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
