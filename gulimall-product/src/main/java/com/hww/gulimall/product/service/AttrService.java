package com.hww.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hww.common.utils.PageUtils;
import com.hww.gulimall.product.entity.AttrEntity;
import com.hww.gulimall.product.vo.AttrGroupRelationVo;
import com.hww.gulimall.product.vo.AttrRespVo;
import com.hww.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String,Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    /**
     * 获取当前分组下且没有被关联的属性
     * @param params
     * @param attrgroupId
     * @return
     */
    PageUtils getNoRelationAttr(Map<String,Object> params, Long attrgroupId);
}

