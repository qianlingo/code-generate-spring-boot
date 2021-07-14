package com.qianlingo.codegenerate.modules.mybatis.vo.system.login;

import lombok.Data;

/**
 * 登录接口 VO
 * @author QianLinGooo
 * @since create in 2021/7/14
 */
@Data
public class SystemLoginVO {

    /**
     * token 名称
     */
    private String tokenName;

    /**
     * token 值
     */
    private String tokenValue;

}
