package com.hww.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hww.common.utils.PageUtils;
import com.hww.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

