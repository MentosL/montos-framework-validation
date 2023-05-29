package com.montos.http.controller;

import com.montos.http.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    @GetMapping("/get/params")
    public String getParams(@RequestParam String id, @RequestParam("name") String userName){
        return id +userName;
    }


    @GetMapping("/sendHello")
    public String sendHello() throws IOException {
        Map<String, String> uriMap = new HashMap<>();
        uriMap.put("id","12111");
        uriMap.put("name","montos");
        String s = helloService.sendGet("http://127.0.0.1:8080/get/params", uriMap);
        return s;
    }

}
