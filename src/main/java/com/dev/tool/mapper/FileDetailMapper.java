package com.dev.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.tool.common.entity.FileDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件记录表(FileDetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-25 13:11:44
 */
@Mapper
public interface FileDetailMapper extends BaseMapper<FileDetail> {
}

