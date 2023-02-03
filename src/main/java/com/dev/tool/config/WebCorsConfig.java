package com.dev.tool.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * -------------------------------------------------------------------------------
 * Copyright © 2022 Beijing YuXiang Software Technology Co., Ltd. All rights reserved.
 * -------------------------------------------------------------------------------
 * Module Name: leetcode-info >>> CorsConfiguration
 * Product:
 * Creator: puye(0303)
 * Date Created: 2022/8/15
 * Description:
 * -------------------------------------------------------------------------------
 * Modification History
 * DATE                       Name                  Description
 * -------------------------------------------------------------------------------
 * 2022/8/15                 puye(0303)                 Create
 * -------------------------------------------------------------------------------
 *
 * @author <a href="mailto:suncx@flamelephant.com">puye(0303)</a>
 */
@Configuration
public class WebCorsConfig {
    private CorsConfiguration buildconfig(){
        CorsConfiguration configuration = new CorsConfiguration();
        //设置请求头，*代表所有
        configuration.addAllowedHeader("*");
        //设置请求方式，这里是允许所有
        configuration.addAllowedMethod("*");
        //设置请求地址，允许所有
        configuration.addAllowedOriginPattern("*");
        //设置跨域请求的时候是否使用同一个session
        configuration.setAllowCredentials(true);
        return configuration;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildconfig());
        return new CorsFilter(source);
    }
}


