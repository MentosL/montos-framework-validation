package com.montos.tkmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author : MentosL
 * @date : 2023/4/27 21:37
 */
@MapperScan("top.zhangsanwan.eat.repository")
@EnableTransactionManagement
@SpringBootApplication
public class OrderTKApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTKApplication.class,args);
    }
}
