package com.dev.tool.service.impl;
import cn.hutool.core.codec.Base64;
import com.dev.tool.common.entity.BaseEntity;
import com.dev.tool.common.entity.DevSysUserEntity;
import com.dev.tool.common.entity.request.BaseRequest;
import com.dev.tool.common.entity.resp.BaseResponse;
import com.dev.tool.common.entity.vo.DevSysUserVO;
import com.dev.tool.common.enums.DevCodeEnum;
import com.dev.tool.common.exception.DevException;
import com.dev.tool.common.utils.JwtUtil;
import com.dev.tool.common.utils.VoUtil;
import com.dev.tool.config.JwtConfig;
import com.dev.tool.mapper.ISysUserMapper;
import com.dev.tool.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author puye(0303)
 * @since 2023/2/2
 */
@Service
@Slf4j
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private JwtConfig config;

    @Resource
    private ISysUserMapper userMapper;

    @Resource
    private JwtUtil jwtUtil;

    /**
     * devTools后台用户登录
     *
     * @param baseRequest 基础请求对象
     * @return 返回一个基础响应
     */
    @Override
    public BaseResponse<? extends BaseEntity> doLogin(BaseRequest baseRequest) {
        // 先获得传入的密码明文
        String password = baseRequest.getPassword();
        // 然后进行加密
        String enCodeResult = Base64.encodeUrlSafe(password.concat(config.getSign()));
        // 获得数据库的字段数据
        DevSysUserEntity devSysUserEntity = userMapper.selectByUserName(baseRequest.getUsername());
        DevSysUserVO devSysUserVO = VoUtil.e2v(devSysUserEntity, DevSysUserVO.class, true);
        // 执行登录
        if (enCodeResult.equals(devSysUserEntity.getPassword())) {
            log.info("用户：{} 登录成功！",devSysUserEntity.getUsername());
            log.info("当前登录用户信息数据：{}", devSysUserEntity);
            // 颁发jwt-token
            String token = jwtUtil.createTokenByUserId(String.valueOf(devSysUserEntity.getId()));
            devSysUserVO.setToken(token);
            return BaseResponse.success(devSysUserVO);
        }
        throw new DevException(DevCodeEnum.ERROR_USER_AUTH_FAILED.getCode(),DevCodeEnum.ERROR_USER_AUTH_FAILED.getMessage());
    }
}
