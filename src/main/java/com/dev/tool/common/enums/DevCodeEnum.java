package com.dev.tool.common.enums;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * -------------------------------------------------------------------------------
 * Copyright © 2022 Leetcode-info-by-fntp. All rights reserved.
 * -------------------------------------------------------------------------------
 * Module Name: leetcode-info >>> LeetcodeRequestTypeEnum
 * Product:devTools >>>
 * Creator: puye(0303)
 * Date Created: 2022/8/2
 * -------------------------------------------------------------------------------
 * Modification History
 * DATE                       Name                  Description
 * -------------------------------------------------------------------------------
 * 2022/8/2                 puye(0303)                 Create
 * -------------------------------------------------------------------------------
 *
 * @author <a href="mailto:stickpoint@163.com">fntp</a>
 */
@Getter
@ToString
@NoArgsConstructor
public enum DevCodeEnum {
    // 成功
    SUCCESS(20000, "success"),
    // 错误
    FAILED(500, "failed"),
    // 200xx 通用错误
    ERROR_DATA_TRANS_EXCEPTION(20001, "数据转换错误"),
    ERROR_DATABASE_FAIL(20002, "数据库操作失败"),
    ERROR_JSON_PARSER(20003, "json结果解析错误"),
    ERROR_JSON_PARAM(20004, "json参数解析错误"),
    ERROR_OPERATION_FAILED(20005, "操作失败"),
    ERROR_FILE_PARSER(20006, "文件解析错误"),
    ERROR_FILE_NOT_EXSIT(20007, "文件不存在"),
    ERROR_PARAM(20008, "参数错误"),
    ERROR_HTTP(20009, "HTTP通信异常"),
    ERROR_HTTP_RETRY(20010, "HTTP通信异常: {retry: %s}"),
    ERROR_FTP(20011, "FTP异常"),
    ERROR_SFTP(20012, "SFTP异常"),
    ERROR_FILE_EXSIT(20013, "文件已存在"),
    ERROR_CREATE_FILE(20014, "文件创建失败"),
    ERROR_READ_FILE(20015, "文件读取失败"),
    ERROR_REGIST_THREADPOOL(20016, "注册线程池失败"),

    // 201xx 用户管理
    ERROR_USER_GET_FAILED(20101, "获取用户信息异常"),
    ERROR_ORG_NOTEXIT(20102, "部门不存在"),
    ERROR_LOCAL_USER_CREATE(20103, "本地用户创建失败"),
    ERROR_LOCAL_USER_DELETE(20104, "本地用户删除失败"),
    ERROR_DEPT_USER_EXIST(20105, "用户已经存在"),
    ERROR_USER_ROLE_NULL(20106, "当前用户角色为空"),
    ERROR_LOGIN_NOT_EXIT(20107, "用户不存在"),
    ERROR_USER_AUTH_FAILED(20108, "用户认证错误"),
    ERROR_CREATE_LOGIN_STATE(20109, "创建临时状态失败"),
    ERROR_LOGIN_STATE(20110, "登录回调状态不合法"),

    // 202xx 业务相关
    ERROR_SCAN_TYPE(20201, "不支持的扫描类型"),
    ERROR_TASK_TYPE(20202, "不支持的任务类型"),
    ERROR_GITLAB_UNREGISTERED(20203, "该gitlab未注册: {gitlabUrl: %s}"),
    ERROR_SONAR_UNREGISTERED(20204, "该sonar未注册: {sonarName: %s}"),
    ERROR_SONAR_SCAN_FAILED(20205, "sonar扫描失败: {sonarProjectName: %s}"),
    ERROR_SONAR_PROJECTKEY(20206, "sonar项目标识异常: {sonarProjectName: %s}"),
    ERROR_MERGE_REQUEST_PARAMS(20207, "合并请求数据异常: {mergeRequestId: %s}"),
    ERROR_SONAR_USER_PARAMS(20208, "sonar用户数据异常: {sonarUserId: %s}"),
    ERROR_MERGE(20209, "合并失败"),
    ERROR_MERGE_REQUEST(20210, "获取合并数据失败: {projectId: %s, mergeId: %s}"),
    ERROR_FILE_REQUEST(20211,"文件下载失败！"),
    ERROR_HTML_MAIL_FAILED(20212,"HTML邮件发送失败！"),

    // 204xx 特殊
    ERROR_AUTHENTICATION(20401, "没有权限"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 构造方法
     *
     * @param code    状态码
     * @param message 信息
     */
    DevCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误代码
     *
     * @return 错误代码
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 获取描述
     *
     * @return 描述信息
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 根据状态码获取信息
     *
     * @param code 状态码
     * @return 信息
     */
    public static String getMessageByCode(int code) {
        for (DevCodeEnum codeEnum : DevCodeEnum.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum.getMessage();
            }
        }
        return "未知异常";
    }

}
