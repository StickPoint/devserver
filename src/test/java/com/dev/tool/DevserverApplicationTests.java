package com.dev.tool;


import cn.hutool.core.codec.Base64;
import com.dev.tool.common.utils.IdUtil;
import com.dev.tool.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DevserverApplicationTests {

    public static void main(String[] args) {
        System.out.println(Base64.encodeUrlSafe("123456".concat("devTools").getBytes()));
        System.out.println(Base64.decodeStr("MTIzNDU2ZGV2VG9vbHM").replaceAll("devTools",""));
        JwtUtil jwtUtil = new JwtUtil();
        long stableSerializeId = IdUtil.getStableSerializeId();
        System.out.println(stableSerializeId);
        //String token = jwtUtil.createTokenByUserId(String.valueOf(stableSerializeId));
    }

}
