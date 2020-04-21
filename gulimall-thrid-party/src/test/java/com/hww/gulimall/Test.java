package com.hww.gulimall;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/19-15:37
 * @Description:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private OSSClient ossClient;

    @org.junit.Test
    public void testUploadFileWithOss() throws FileNotFoundException {
        // 上传文件流。
        InputStream inputStream = new FileInputStream("G:\\图片壁纸\\101.jpg");
        ossClient.putObject("hww-bucket-gulimall", "100.jpg", inputStream);
        System.out.println("file upload success....");
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
