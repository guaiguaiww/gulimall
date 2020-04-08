package com.hww.gulimall.member.feign;

import com.hww.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/8-0:13
 * @Description:
 */
@FeignClient("gulimall-coupon")
public interface CouponServiceFeign {


    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
