package com.dev.tool.common.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author SunChengXin_0303
 * @ClassName SystemConst.Class
 * @PackageName org.leetcode.fntp.enums
 * @jdk_version 1.8
 * @Date 2022年08月09日 17:30
 * @since 1.5
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum SystemConst {
    /**
     * userId
     */
    SYS_CONST_USER_ID("userId"),
    SYS_CONST_USER_NAME("username"),
    SYS_CONST_SALT("salt"),
    SYS_CONST_SSO_TOKEN("ssoToken")
    ,;
    private String name;
    private Integer number;
    SystemConst(Integer number){
        this.number = number;
    }
    SystemConst(String name){
        this.name = name;
    }
}
