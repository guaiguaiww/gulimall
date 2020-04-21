package com.hww.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
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


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

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
                    item.setChildrenCategoryEntities(getChildrenCategories(item, allCategories));
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
                    item.setChildrenCategoryEntities(getChildrenCategories(item,allCategories));
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

}