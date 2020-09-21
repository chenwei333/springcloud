package com.wei.controller;

import com.wei.entities.Payment;
import com.wei.result.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("comsumer")
public class OrderController {

//    public static final String PAYENT_URL = "http://localhost:8001"; //通过Ip访问

    public static final String PAYENT_URL = "http://CLOUD-PAYMENT-SERVICE";  //通过服务进行访问

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("payment/create")
    public SimpleResponse<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYENT_URL+"/payment/create",payment,SimpleResponse.class);
    }
    @GetMapping("payment/selectOne/{id}")
    public SimpleResponse<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYENT_URL+"/payment/get/"+id,SimpleResponse.class);
    }

    @GetMapping("payment/selectForEntry/{id}")
    public SimpleResponse<Payment> selectForEntry(@PathVariable("id") long id) {
        ResponseEntity<SimpleResponse> forEntity = restTemplate.getForEntity(PAYENT_URL + "/payment/get/" + id, SimpleResponse.class);
        if(forEntity.getStatusCode() == HttpStatus.OK){
            return forEntity.getBody();
        }
        return null;
    }

}
