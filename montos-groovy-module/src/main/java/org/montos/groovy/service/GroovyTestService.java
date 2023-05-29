package org.montos.groovy.service;

import org.springframework.stereotype.Service;

@Service
public class GroovyTestService {

    public void test1(){
        System.out.println("我是SpringBoot框架的成员类，但该方法由Groovy脚本调用 --1");
    }


    public void test2(){
        System.out.println("我是SpringBoot框架的成员类，但该方法由Groovy脚本调用 --2");
    }

}