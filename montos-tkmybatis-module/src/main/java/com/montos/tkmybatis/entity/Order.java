package com.montos.tkmybatis.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : MentosL
 * @date : 2023/4/27 21:42
 */
@Table(name = "order_test")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "store_id")
    private String storeId;
    @Column(name = "goods_id")
    private String goodsId;
}
