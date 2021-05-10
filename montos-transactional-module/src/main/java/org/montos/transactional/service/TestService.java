package org.montos.transactional.service;

import org.montos.transactional.dao.TestDao;
import org.montos.transactional.entity.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Montos
 * @create 2021/1/30 10:44 下午
 */
@Service
public class TestService {
    @Autowired
    private TestDao testDao;


    public void test(){
        add();
    }

    @Transactional
    public  void add() {
        List<Test> list = new ArrayList<>();
        Test test = new Test();
        test.setCreateTime(new Date());
        test.setId(33);
        test.setOne(33 + "");
        test.setTwo(33 + "");
        list.add(test);
        testDao.insert(list);
        int i = 1 / 0;
    }

}
