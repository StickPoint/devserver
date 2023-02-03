package com.dev.tool.common.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 文件记录表(FileDetail)实体类
 *
 * @author makejava
 * @since 2022-11-15 12:59:25
 */
@Data
@ToString
@Builder
public class FileDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = 449518964338165874L;
    /**
     * 文件id
     */
    private String id;
    /**
     * 文件访问地址
     */
    private String url;
    /**
     * 文件大小，单位字节
     */
    private Long size;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 原始文件名
     */
    private String originalFilename;
    /**
     * 基础存储路径
     */
    private String basePath;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 文件扩展名
     */
    private String ext;
    /**
     * MIME类型
     */
    private String contentType;
    /**
     * 存储平台
     */
    private String platform;
    /**
     * 缩略图访问路径
     */
    private String thUrl;
    /**
     * 缩略图名称
     */
    private String thFilename;
    /**
     * 缩略图大小，单位字节
     */
    private Long thSize;
    /**
     * 缩略图MIME类型
     */
    private String thContentType;
    /**
     * 文件所属对象id
     */
    private String objectId;
    /**
     * 文件所属对象类型，例如用户头像，评价图片
     */
    private String objectType;
    /**
     * 附加属性
     */
    private String attr;
    /**
     * 创建时间
     */
    private Date createTime;

}

