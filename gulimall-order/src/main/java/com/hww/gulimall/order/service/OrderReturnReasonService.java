package com.hww.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hww.common.utils.PageUtils;
import com.hww.gulimall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 23:25:11
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

