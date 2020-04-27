package com.hww.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hww.common.utils.PageUtils;
import com.hww.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);
}

