package com.hww.gulimall.product;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hww.gulimall.product.entity.BrandEntity;
import com.hww.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/7-21:41
 * @Description:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {

    @Autowired
    private BrandService brandService;




    public void testInsert() {
        BrandEntity brandEntity = BrandEntity.builder().name("iphone").descript("好用手机").build();
        brandService.save(brandEntity);
        System.out.println("保存成功");

    }


    public void testSelect() {
        List<BrandEntity> brandEntities = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        brandEntities.forEach(item -> {
            log.info(item.getName() + "," + item.getDescript());
        });

    }



}
