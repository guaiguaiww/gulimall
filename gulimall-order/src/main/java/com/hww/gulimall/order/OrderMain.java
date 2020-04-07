package com.hww.gulimall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-23:21
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.hww.gulimall.order.dao")
public class OrderMain {
     public static void main(String[] args) {
             SpringApplication.run(OrderMain.class,args);
         }
}
