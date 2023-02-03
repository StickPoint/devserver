package com.dev.tool.controller.admin;
import com.dev.tool.common.entity.BaseEntity;
import com.dev.tool.common.entity.request.BaseRequest;
import com.dev.tool.common.entity.resp.BaseResponse;
import com.dev.tool.common.enums.DevCodeEnum;
import com.dev.tool.common.exception.DevException;
import com.dev.tool.service.ISysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author puye(0303)
 * @since 2023/2/2
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService userService;

    @PostMapping("/login")
    public BaseResponse<? extends BaseEntity> doLogin(@RequestBody BaseRequest baseRequest) {
        if (Objects.isNull(baseRequest.getUsername())||Objects.isNull(baseRequest.getPassword())) {
            throw new DevException(DevCodeEnum.ERROR_PARAM.getCode(), DevCodeEnum.ERROR_PARAM.getMessage());
        }
        return userService.doLogin(baseRequest);
    }
}
