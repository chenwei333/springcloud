package com.wei.service.impl;

import com.wei.result.CommonResponse;
import com.wei.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springcloud
 * @Package: com.wei.service.impl
 * @ClassName: PaymentHystrixServiceImpl
 * @Author: chenwei
 * @Description: 服务异常处理类
 * @Date: 2020/10/14
 * @Version: 1.0
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentFeignHystrixService {
    @Override
    public CommonResponse doSuccess(Integer id) {
        System.out.println("--------doSuccess----+ 异常处理");
        return null;
    }

    @Override
    public CommonResponse doError(Integer id) {
        System.out.println("--------doError----+ 错误的异常处理");
        return null;
    }

    @Override
    public CommonResponse doTimeOut(Integer id) {
        System.out.println("--------doTimeOut----+ 错误的异常处理");
        return null;
    }
}
