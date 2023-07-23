package com.montos.http.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("hello/interface/")
public interface HelloInterface {

     @PostMapping("post/v1/{name}")
     String getName(@PathVariable("name") String name,@RequestParam("mm") String mm);

     @PostMapping("post/v1/{age}")
     String getAge(@PathVariable("age") Integer age);


}
