package com.dev.tool.controller;
import cn.xuyanwu.spring.file.storage.FileInfo;
import com.dev.tool.service.FileOperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author puye(0303)
 */
@RestController
@RequestMapping("/file")
public class FileDetailController {

    @Resource
    private FileOperationService fileOperationService;

    /**
     * 上传文件，成功返回文件 url
     * @param file 待上传文件
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        return fileOperationService.upload(file);
    }

    /**
     * 上传图片，成功返回文件信息
     * 图片处理使用的是 https://github.com/coobird/thumbnailator
     */
    @PostMapping("/upload-image")
    public FileInfo uploadImage(MultipartFile file) {
        return fileOperationService.uploadImage(file);
    }

    /**
     * 上传文件到指定存储平台，成功返回文件信息
     */
    @PostMapping("/upload-platform")
    public FileInfo uploadPlatform(MultipartFile file) {
        return fileOperationService.uploadPlatform(file);
    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response, @RequestParam("url") String url){
        fileOperationService.downloadFile(response,url);
    }
}
