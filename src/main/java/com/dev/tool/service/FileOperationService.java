package com.dev.tool.service;

import cn.xuyanwu.spring.file.storage.FileInfo;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * description: FileOperationService
 *
 * @ClassName : FileOperationService
 * @Date 2022/11/15 12:18
 * @Author puye(0303)
 * @PackageName com.dev.tool.service
 */
public interface FileOperationService {
    /**
     * 根据文件上传之后返回的地址来进行请求下载
     * @param response 传入一个基础的http请求
     * @param requestFileUrl 传入一个请求
     */
    void downloadFile(HttpServletResponse response, String requestFileUrl);

    /**
     * 文件上传
     * @param file 传入一个文件参数
     * @return 返回一个上传的结果
     */
    String upload(MultipartFile file);

    /**
     * 上传图片
     * @param file 传入一个文件类型的参数
     * @return 返回一个文件信息
     */
    FileInfo uploadImage(MultipartFile file);

    /**
     * 上传平台
     * @param file 传入一个文件类型的参数
     * @return 返回一个文件信息
     */
    FileInfo uploadPlatform(MultipartFile file);
}
