package com.example.demo.service;

import com.example.demo.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_order】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface OrderService extends IService<Order> {
    /*处理订单数据动态多条件分页查询*/
    public Map<String,Object> queryOrderListService(Integer pageNum, Integer pageSize,Order order);
}
