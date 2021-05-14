package org.montos.pageHelper.controller;

import org.montos.pageHelper.entity.Test;
import org.montos.pageHelper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Montos
 * @create 2021/5/12 5:53 下午
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("list")
    public List<Test> list(){
        return testService.getList();
    }
}
