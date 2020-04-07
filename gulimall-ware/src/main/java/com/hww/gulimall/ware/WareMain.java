package com.hww.gulimall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-23:32
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.hww.gulimall.ware.dao")
public class WareMain {
}
