package com.hww.gulimall.order.dao;

import com.hww.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 23:25:11
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
