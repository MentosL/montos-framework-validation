package org.montos.page.dao;

import org.apache.ibatis.annotations.Select;
import org.montos.page.entity.Test;

import java.util.List;

/**
 * @author Montos
 * @create 2021/5/10 9:28 上午
 */
public interface ITestDao {

    @Select("select * from test")
    List<Test> getAll();
}
