package com.hww.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.hww.common.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hww.gulimall.order.dao.OrderSettingDao;
import com.hww.gulimall.order.entity.OrderSettingEntity;
import com.hww.gulimall.order.service.OrderSettingService;


@Service("orderSettingService")
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingDao, OrderSettingEntity> implements OrderSettingService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}