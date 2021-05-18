package org.montos.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Montos
 * @create 2021/5/14 10:28 上午
 */
@RefreshScope
@RestController
public class ValueController {


    private String value;

    @NacosValue(value = "${username:world}", autoRefreshed = true)
    public ValueController setValue(String value) {
        this.value = value;
        return this;
    }

    @RequestMapping("printValue")
    public void printValue(){
        System.out.println(value);
    }
}
