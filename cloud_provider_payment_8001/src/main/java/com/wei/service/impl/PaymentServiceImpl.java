package com.wei.service.impl;

import com.wei.entities.Payment;
import com.wei.mapper.PaymentMapper;
import com.wei.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper mapper;

    public Payment queryById(Long id) {
        return mapper.queryById(id);
    }

    public List<Payment> queryAllByLimit(int offset, int limit) {
        return mapper.queryAllByLimit(offset, limit);
    }

    public Payment insert(Payment payment) {
         mapper.insert(payment);
         return payment;
    }

    public Payment update(Payment payment) {
        mapper.update(payment);
        return payment;
    }

    public boolean deleteById(Long id) {
         return mapper.deleteById(id)==1;
    }
}
