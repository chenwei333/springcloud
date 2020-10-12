package com.wei.controller;

import com.wei.entities.Payment;
import com.wei.result.CommonResponse;
import com.wei.result.ListResponse;
import com.wei.result.SimpleResponse;
import com.wei.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ProjectName: springcloud
 * @Package: com.wei.controller
 * @ClassName: PaymentController
 * @Author: chenwei
 * @Description: 支付api
 * @Date: 2020/9/19
 * @Version: 1.0
 */
@RestController
@RequestMapping("paymentHystrix")
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("doSuccess/{id}")
    public CommonResponse doSuccess(@PathVariable("id") Integer id) {
        paymentService.doSuccess(id);
        return new CommonResponse(" 执行成功 " + this.serverPort );
    }

    @GetMapping("doError/{id}")
    public CommonResponse doError(@PathVariable("id") Integer id) {
        paymentService.doError(id);
        return new CommonResponse("执行失败 " + this.serverPort );
    }
    @GetMapping("doTimeOut/{id}")
    public CommonResponse doTimeOut(@PathVariable("id") Integer id) {
        paymentService.doTimeOut(id);
        return new CommonResponse("执行时间 " + this.serverPort );
    }

}
