package com.hww.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hww.common.utils.PageUtils;
import com.hww.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.hww.gulimall.product.entity.AttrEntity;
import com.hww.gulimall.product.vo.AttrGroupRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加属性分组与属性关系
     * @param vos
     */
    void saveBatch(List<AttrGroupRelationVo> vos);
}

