package com.dev.tool.service.impl;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import com.dev.tool.service.FileDetailService;
import com.dev.tool.service.FileOperationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: FileOperationServiceImpl
 *
 * @ClassName : FileOperationServiceImpl
 * @Date 2022/11/15 12:19
 * @Author puye(0303)
 * @PackageName com.dev.tool.service.impl
 */
@Service
public class FileOperationServiceImpl implements FileOperationService {

    @Resource
    private FileStorageService storageService;

    @Resource
    private FileDetailService fileDetailService;

    /**
     * 根据文件上传之后返回的地址来进行请求下载
     *
     * @param response       传入一个基础的http请求
     * @param requestFileUrl 传入一个请求
     */
    @Override
    public void downloadFile(HttpServletResponse response, String requestFileUrl) {
        // 获取文件信息
        FileInfo fileInfo = fileDetailService.getByUrl(requestFileUrl);
        // 下载到 OutputStream 中
        try (ServletOutputStream outputStream = response.getOutputStream()){
            storageService.download(fileInfo).outputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String upload(MultipartFile file) {
        FileInfo fileInfo = storageService.of(file)
                .setPath("upload/")
                //保存到相对路径下，为了方便管理，不需要可以不写
                .setObjectId("0")
                //关联对象id，为了方便管理，不需要可以不写
                .setObjectType("0")
                //关联对象类型，为了方便管理，不需要可以不写
                .putAttr("role","admin")
                //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .upload();
        //将文件上传到对应地方
        return fileInfo == null ? "上传失败！" : fileInfo.getUrl();
    }

    @Override
    public FileInfo uploadImage(MultipartFile file) {
        return storageService.of(file)
                //将图片大小调整到 1000*1000
                .image(img -> img.size(1000,1000))
                //再生成一张 200*200 的缩略图
                .thumbnail(th -> th.size(200,200))
                .upload();
    }

    @Override
    public FileInfo uploadPlatform(MultipartFile file) {
        //使用指定的存储平台
        return storageService.of(file)
                .setPlatform("aliyun-oss-1")
                .upload();
    }
}
