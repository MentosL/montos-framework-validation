package org.montos.page.controller;

import org.montos.page.dao.ITestDao;
import org.montos.page.entity.Test;
import org.montos.page.page.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Montos
 * @create 2021/5/10 9:32 上午
 */
@RestController
public class TestController {

    @Autowired
    private ITestDao testDao;

    @RequestMapping("/getAll")
    public void getAll(){
        PageInterceptor.startPage(1,1);
        List<Test> all = testDao.getAll();
        System.out.println(all.size());
    }


}
