package com.hww.gulimall.product.dao;

import com.hww.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
