package org.montos.jdbctemplate.service;

import org.montos.jdbctemplate.dao.TestDao;
import org.montos.jdbctemplate.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void add(){
        List<Test> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Test test = new Test();
            test.setCreateTime(new Date());
            test.setId(i);
            test.setOne(i+"");
            test.setTwo(i+"");
            list.add(test);
        }
        testDao.insert(list);
    }

}
