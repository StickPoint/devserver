package com.dev.tool.service;
import com.dev.tool.common.entity.BaseEntity;
import com.dev.tool.common.entity.request.BaseRequest;
import com.dev.tool.common.entity.resp.BaseResponse;

/**
 * @author puye(0303)
 * @since 2023/2/2
 */
public interface ISysUserService {

    /**
     * devTools后台用户登录
     * @param baseRequest 基础请求对象
     * @return 返回一个基础响应
     */
    BaseResponse<? extends BaseEntity> doLogin(BaseRequest baseRequest);
}
