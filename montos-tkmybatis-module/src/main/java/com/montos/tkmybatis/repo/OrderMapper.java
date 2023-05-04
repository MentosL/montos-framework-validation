package com.montos.tkmybatis.repo;

import com.montos.tkmybatis.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : MentosL
 * @date : 2023/4/27 21:44
 */
@Mapper
public interface OrderMapper  extends BaseMapper<Order> {
}
