package com.dev.tool.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dev.tool.common.enums.SystemConst;
import com.dev.tool.config.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Objects;

/**
 * @author fntp
 */
@Component
@Slf4j
public class JwtUtil {

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 创建token
     * @param userId 传入一个userId
     * @return 返回一个用户token信息
     */
    public String createTokenByUserId(String userId){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(SystemConst.SYS_CONST_USER_ID.getName(), userId);
        builder.withClaim(SystemConst.SYS_CONST_SALT.getName(), jwtConfig.getSalt());
        builder.withSubject(SystemConst.SYS_CONST_SSO_TOKEN.getName());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,jwtConfig.getExpiration());
        builder.withExpiresAt(calendar.getTime());
        return builder.sign(Algorithm.HMAC256(jwtConfig.getSign()));
    }

    /**
     * 传入一个JsonWebToken字符串
     * @param jsonWebTokenStr token字符串
     * @return 返回一个校验token的结果
     */
    public Boolean checkTokenFromUser(String userId, String jsonWebTokenStr){
        DecodedJWT verifyResult = JWT.require(Algorithm.HMAC256(jwtConfig.getSign())).build().verify(jsonWebTokenStr);
        String subject = verifyResult.getSubject();
        if (Objects.nonNull(subject)) {
            return userId.equals(verifyResult.getClaim(SystemConst.SYS_CONST_USER_ID.getName()).asString());
        }
        return false;
    }

}