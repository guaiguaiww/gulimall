package com.hww.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/14-15:09
 * @Description: 解决跨域问题
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        //配置跨域
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");//请求头
        corsConfiguration.addAllowedMethod("*");//请求方法
        corsConfiguration.addAllowedOrigin("*");//请求来源
        corsConfiguration.setAllowCredentials(true);//是否允许携带cookie进行跨域
        /**
         * 设置跨域配置
         * path: 可跨域的路径
         */
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }
}
