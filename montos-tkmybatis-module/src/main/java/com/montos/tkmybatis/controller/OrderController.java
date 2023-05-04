package com.montos.tkmybatis.controller;

import com.montos.tkmybatis.entity.Order;
import com.montos.tkmybatis.repo.OrderMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : MentosL
 * @date : 2023/4/27 21:46
 */
@RestController
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @RequestMapping("getAll")
    public void selectAll(){
        Example example = new Example(Order.class);
        example.createCriteria().andIsNotNull("id");
        List<Order> Orders = orderMapper.selectByExample(example);
        System.out.println(Orders.size());
    }
}
