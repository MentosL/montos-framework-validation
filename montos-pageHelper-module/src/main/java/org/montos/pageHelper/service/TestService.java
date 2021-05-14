package org.montos.pageHelper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.montos.pageHelper.dao.TestDao;
import org.montos.pageHelper.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Montos
 * @create 2021/5/12 5:22 下午
 */
@Service
public class TestService {

    @Autowired
    TestDao testDao;


    public List<Test> getList(){
        Page<Test> objects = PageHelper.startPage(0, 0).doSelectPage(() -> testDao.list());
        List<Test> result = objects.getResult();
        PageInfo<Test> testPageInfo = objects.toPageInfo();
        return testPageInfo.getList();
    }


}
