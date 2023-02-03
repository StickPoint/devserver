package com.dev.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.tool.common.entity.DevSysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author puye(0303)
 * @since 2023/2/2
 */
@Mapper
public interface ISysUserMapper extends BaseMapper<DevSysUserEntity> {

    /**
     * 根据账户查询用户
     * @param userName 账户
     * @return 用户信息
     */
    @Select({"select * from dev_sys_user where username = #{username}"})
    DevSysUserEntity selectByUserName(@Param("username") String userName);

}
