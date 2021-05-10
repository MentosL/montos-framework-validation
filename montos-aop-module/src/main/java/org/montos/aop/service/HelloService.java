package org.montos.aop.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Montos
 * @create 2021/1/26 9:54 下午
 */
@Component
public class HelloService {


    public void A(String name){
        System.out.println("a"+name);
        HelloService o =(HelloService) AopContext.currentProxy();
        o.B(name);
    }

    public void B(String name){
        System.out.println("b"+name);
    }
}
