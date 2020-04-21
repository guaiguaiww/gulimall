package com.hww.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/8-21:30
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GateWayMain {
     public static void main(String[] args) {
             SpringApplication.run(GateWayMain.class,args);
         }
}
