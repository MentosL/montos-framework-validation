package org.montos.metrics.controller;

import com.codahale.metrics.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    private Meter requestMeter;



    @RequestMapping("/hello")
    public String helloWorld() {
        requestMeter.mark();
        return "Hello World";
    }
}
