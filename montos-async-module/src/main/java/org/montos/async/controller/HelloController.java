package org.montos.async.controller;

import org.montos.async.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Montos
 * @create 2021/2/23 9:25 上午
 */
@RestController
public class HelloController {

    private HelloService helloService;


    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("hello")
    public void hello(){
        helloService.sayHello();
    }
}
