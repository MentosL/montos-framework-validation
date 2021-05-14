package org.montos.pageHelper.dao;

import org.montos.pageHelper.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Montos
 * @create 2021/5/12 5:42 下午
 */
@Component
public class TestDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String sql = "select * from test";

    public List<Test> list() {
        List<Test> id = namedParameterJdbcTemplate.query(sql, (resultSet, i) -> {
            Test test = new Test();
            test.setId(resultSet.getInt("id"));
            return test;
        });
        return id;
    }
}

