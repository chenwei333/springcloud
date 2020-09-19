package com.wei.service;

import com.wei.entities.Payment;

import java.util.List;

public interface PaymentService {


    /**
     * 功能描述: <根据id查询>
     * 〈〉
     * @Param: [id]
     * @Return: com.wei.entities.Payment
     * @Author: 陈伟
     * @Date: 2020/9/19 8:55
     */

    Payment queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Payment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
