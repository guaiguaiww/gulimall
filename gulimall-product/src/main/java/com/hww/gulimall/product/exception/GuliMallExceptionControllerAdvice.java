package com.hww.gulimall.product.exception;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.hww.common.exception.BizCodeEnum;
import com.hww.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author heweiwei@hztianque.com
 * @date 2020/4/21-0:33
 * @Description: 同一处理异常
 */
@RestControllerAdvice(basePackages = "com.hww.gulimall.product.controller")
public class GuliMallExceptionControllerAdvice {

    private static final Log log = LogFactory.get();

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{},异常类型{}", e, e.getClass());
        BindingResult result = e.getBindingResult();
        HashMap<String, String> map = CollectionUtil.newHashMap();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(item -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put(field, message);
            });
        }
        return R.error(BizCodeEnum.VALIDATEEXCEPTION.getCode(), BizCodeEnum.VALIDATEEXCEPTION.getMessage()).put("data", map);
    }

    /*@ExceptionHandler(value = Throwable.class)
    public R handleAnyException(Throwable throwable) {
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
    }*/
}
