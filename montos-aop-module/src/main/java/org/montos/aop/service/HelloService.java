package org.montos.aop.service;

import org.montos.aop.annotation.Test;
import org.springframework.stereotype.Component;

/**
 * @author Montos
 * @create 2021/1/26 9:54 下午
 */
@Component
public class HelloService {


    @Test
    public void A(String name){
        System.out.println(name);
        B(name);
    }

    @Test
    public void B(String name){

    }
}
