package org.montos.transactional.controller;

import lombok.AllArgsConstructor;
import org.montos.transactional.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Montos
 * @create 2021/1/30 10:17 下午
 */
@AllArgsConstructor
@RestController
public class TestController {

    private TestService testService;

    @RequestMapping("api/add")
    public  void add(){
        testService.add();
    }
}
