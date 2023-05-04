package org.montos.aop.service;

import org.springframework.stereotype.Component;


/**
 * @author Montos
 * @create 2021/1/26 9:54 下午
 */
@Component
public class HelloService {

    String name = "";
    int i =0;


    public String getName(){
        i++;
       return name + i;
    }

    public void setName() {
        name = "montos";
    }
}
