package com.hww.gulimall.product.dao;

import com.hww.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {


    List<BrandEntity> findAllBrandEntities(BrandEntity params);
}
