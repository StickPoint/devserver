package com.dev.tool.common.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author SunChengXin_0303
 * @ClassName BaseRequest.Class
 * @PackageName com.generator.finashell.bean
 * @Date 2022年07月20日 11:59
 * @since 1.5
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest implements Serializable {

    private String userId;

    private String username;

    private String version;

    private String password;

    private String icon;

    private String email;

    private String nickname;

    private String mark;

    private long id;

    private int status;

}
