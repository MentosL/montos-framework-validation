package org.montos.groovy.controller;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.montos.groovy.req.GroovyRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groovy/")
public class GroovyController {

    GroovyShell groovyShell = new GroovyShell();

    @RequestMapping("test")
    public String sayString(@RequestBody GroovyRequest groovyRequest){
        //装载解析脚本代码
        Script scriptBean = groovyShell.parse(groovyRequest.getScript());
        //执行
        scriptBean.invokeMethod(groovyRequest.getMethod(), groovyRequest.getArgs());
        return "ok";
    }
}
