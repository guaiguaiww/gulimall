package com.hww.gulimall.product.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.hww.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hww.common.utils.PageUtils;
import com.hww.common.utils.Query;

import com.hww.gulimall.product.dao.CategoryDao;
import com.hww.gulimall.product.entity.CategoryEntity;
import com.hww.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> allCategories = baseMapper.selectList(null);
        //一级分类
        List<CategoryEntity> parentCategoryEntities = allCategories.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(item -> {
                    item.setChildren(getChildrenCategories(item, allCategories));
                    return item;
                })
                .sorted(Comparator.comparingInt(item -> (item.getSort() == null ? 0 : item.getSort())))
                .collect(Collectors.toList());
        return parentCategoryEntities;
    }


    /**
     * 给一级类别递归设置子分类
     *
     * @param parentCategoryEntity 分类列表中的parentId==0的每一项
     * @param allCategories        所有分类
     * @return
     */
    private List<CategoryEntity> getChildrenCategories(CategoryEntity parentCategoryEntity, List<CategoryEntity> allCategories) {
        List<CategoryEntity> childrenCategories = allCategories.stream()
                .filter(item -> parentCategoryEntity.getCatId() == item.getParentCid())
                .map(item -> {
                    item.setChildren(getChildrenCategories(item, allCategories));
                    return item;
                })
                .sorted(Comparator.comparingInt(item -> (item.getSort() == null ? 0 : item.getSort())))
                .collect(Collectors.toList());
        return childrenCategories;
    }

    @Override
    public void removeByCatIds(List<Long> longs) {
        //TODO 检测当前菜单是否被引用
        baseMapper.deleteBatchIds(longs);
    }

    @Override
    public Long[] findCateLogPath(Long catelogId) {
        ArrayList<Long> objects = CollectionUtil.newArrayList();
        List<Long> realPath = findParentPAth(catelogId, objects);
        return realPath.toArray(new Long[realPath.size()]);
    }

    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        //同步更新关联表中的数据
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    private List<Long> findParentPAth(Long catelogId, ArrayList<Long> list) {
        list.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPAth(byId.getParentCid(), list);
        }
        return CollectionUtil.reverseNew(list);
    }

}