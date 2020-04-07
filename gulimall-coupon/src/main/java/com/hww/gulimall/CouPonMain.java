package com.hww.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-22:42
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.hww.gulimall.coupon.dao")
public class CouPonMain {
    public static void main(String[] args) {
        SpringApplication.run(CouPonMain.class, args);
    }
}
