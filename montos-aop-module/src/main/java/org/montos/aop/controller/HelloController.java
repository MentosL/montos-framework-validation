package org.montos.aop.controller;

import org.montos.aop.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Montos
 * @create 2021/1/26 9:55 下午
 */
@RestController
@RequestMapping("/api/")
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("gettest")
    public String name() {
        return helloService.getName();
    }

    @RequestMapping("setName")
    public void setName() {
        helloService.setName();
    }

    @RequestMapping("getBody")
    public String getBody(@RequestBody Body body){
        return "hello";
    }



    public static class Body{
        String name;
        String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
