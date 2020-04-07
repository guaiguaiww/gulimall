package com.hww.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-23:14
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.hww.gulimall.member.dao")
public class MemberMain {
    public static void main(String[] args) {
        SpringApplication.run(MemberMain.class, args);
    }
}
