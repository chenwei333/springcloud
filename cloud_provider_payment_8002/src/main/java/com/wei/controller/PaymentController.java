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
@RequestMapping("payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient; //获取注册中心的信息

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public SimpleResponse<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);

        return new SimpleResponse<Payment>(payment,"select success! ---- " + this.serverPort);
    }

    @PostMapping("create")
    public CommonResponse create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.insert(payment);
        System.out.println(insert);
        System.out.println("1234567890");
        return new CommonResponse("insert success---" + this.serverPort);
    }

    @GetMapping("get/selectMsg")
    public ListResponse<ServiceInstance> selectMsg() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service->{
            System.out.println("----service"+service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t" + instance.getHost()+"\t"+ instance.getPort()+"\t"+instance.getUri());;
        }

        return new ListResponse<>(instances,"查询数据信息成功");


    }

}
