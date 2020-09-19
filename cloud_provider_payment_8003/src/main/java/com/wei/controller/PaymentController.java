package com.wei.controller;

import com.wei.entities.Payment;
import com.wei.result.CommonResponse;
import com.wei.result.SimpleResponse;
import com.wei.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("payment")
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
    @GetMapping("get/{id}")
    public SimpleResponse<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);

        return new SimpleResponse<Payment>(payment,"select success ! ---- " + this.serverPort);
    }

    @PostMapping("create")
    public CommonResponse create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.insert(payment);
        System.out.println(insert);
        System.out.println("1234567890");
        return new CommonResponse("insert success ------ " + this.serverPort);
    }


}
