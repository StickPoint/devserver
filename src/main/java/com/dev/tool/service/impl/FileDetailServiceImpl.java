package com.dev.tool.service.impl;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.recorder.FileRecorder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.tool.mapper.FileDetailMapper;
import com.dev.tool.common.entity.FileDetail;
import com.dev.tool.service.FileDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
/**
 * description: FileDetailServiceImpl
 *
 * @ClassName : FileDetailServiceImpl
 * @Date 2022/10/25 13:09
 * @Author puye(0303)
 * @PackageName com.dev.tool.service.impl
 */
@Service
public class FileDetailServiceImpl extends ServiceImpl<FileDetailMapper, FileDetail> implements FileDetailService, FileRecorder {

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public boolean record(FileInfo info) {
        FileDetail detail = BeanUtil.copyProperties(info,FileDetail.class,"attr");
        //这是手动获 取附加属性字典 并转成 json 字符串，方便存储在数据库中
        if (info.getAttr() != null) {
            detail.setAttr(new ObjectMapper().writeValueAsString(info.getAttr()));
        }
        boolean b = save(detail);
        if (b) {
            info.setId(detail.getId());
        }
        return b;
    }

    /**
     * 根据 url 查询文件信息
     */
    @SneakyThrows(JsonProcessingException.class)
    @Override
    public FileInfo getByUrl(String url) {
        LambdaQueryWrapper<FileDetail> wrapper = new LambdaQueryWrapper<>();
        FileDetail detail = getOne(wrapper.eq(FileDetail::getUrl,url));
        FileInfo info = BeanUtil.copyProperties(detail,FileInfo.class,"attr");
        //这是手动获取数据库中的 json 字符串 并转成 附加属性字典，方便使用
        if (CharSequenceUtil.isNotBlank(detail.getAttr())) {
            info.setAttr(new ObjectMapper().readValue(detail.getAttr(), Dict.class));
        }
        return info;
    }



    /**
     * 根据 url 删除文件信息
     */
    @Override
    public boolean delete(String url) {
        LambdaQueryWrapper<FileDetail> wrapper = new LambdaQueryWrapper<>();
        return remove(wrapper.eq(FileDetail::getUrl,url));
    }


}
