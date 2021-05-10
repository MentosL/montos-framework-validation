package org.montos.aop.controller;

import org.montos.aop.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Montos
 * @create 2021/1/26 9:55 下午
 */
@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController( HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/api/test")
    public void name(){
        helloService.A("montos");
    }
}
