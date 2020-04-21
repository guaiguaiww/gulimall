package com.hww.gulimall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/19-15:17
 * @Description: 专门用于和第三方对接的服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ThirdPartyMain {
    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyMain.class, args);
    }
}
