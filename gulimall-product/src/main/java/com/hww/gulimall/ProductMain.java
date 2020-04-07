package com.hww.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-20:19
 * @Description:
 */
@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.hww.gulimall.product.dao")
public class ProductMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }
}
