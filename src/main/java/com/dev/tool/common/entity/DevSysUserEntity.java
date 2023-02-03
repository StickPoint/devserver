package com.dev.tool.common.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * devTools-系统后台-用户表(DevSysUser)实体类
 *
 * @author makejava
 * @since 2023-02-02 18:15:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Builder
public class DevSysUserEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 296633956977632066L;
    /**
     * 账号id
     */
    private Long id;
    /**
     * 用户登录账号
     */
    private String username;
    /**
     * 用户登录密文
     */
    private String password;
    /**
     * 头像
     */
    private String icon;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 备注信息
     */
    private String mark;
    /**
     * 信息创建时间
     */
    private Date createTime;
    /**
     * 信息更新时间
     */
    private Date updateTime;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

}

