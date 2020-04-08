package com.hww.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-23:14
 * @Description: @EnableFeignClients : 开启远程调用
 */
@EnableFeignClients(basePackages = "com.hww.gulimall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.hww.gulimall.member.dao")
public class MemberMain {
    public static void main(String[] args) {
        SpringApplication.run(MemberMain.class, args);
    }
}
