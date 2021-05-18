package org.montos.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Montos
 * @create 2021/2/23 9:26 上午
 */
@Service
public class HelloService {


    @Async
    public  void sayHello(){
        System.out.println("hello world");
    }


    public void sayHello2(){
        System.out.println("hello world2");
    }
}
