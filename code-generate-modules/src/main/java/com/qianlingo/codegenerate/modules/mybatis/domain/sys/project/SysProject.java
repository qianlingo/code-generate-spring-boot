package com.qianlingo.codegenerate.modules.mybatis.domain.sys.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author QianLinGooo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 项目组编号
     */
    private String projectTeamId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否查询部署项目所属数据源(0:按用户填写的数据源进行信息获取,1:按项目部署所属数据源进行信息获取)
     */
    private Integer ifQueryLocalDb;

    /**
     * 状态(0:禁用,1:启用)
     */
    private Integer status;


}
