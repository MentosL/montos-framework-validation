package org.montos.transactional.dao;

import org.montos.transactional.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Montos
 * @create 2021/1/30 10:17 下午
 */
@Repository
public class TestDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String sql = "insert ignore into test.test (id, one, two, createTime) values (:id, :one, :two, :createTime);";


    public void insert(List<Test> list){

        List<Map<String,Object>> insertMap = new ArrayList<>();

        for (Test test:list) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",test.getId());
            map.put("one",test.getOne());
            map.put("two",test.getTwo());
            map.put("createTime",test.getCreateTime());
            insertMap.add(map);
        }


        int[] ints = namedParameterJdbcTemplate.batchUpdate(sql, (Map<String, ?>[]) insertMap.toArray(new HashMap[0]));

        System.out.println(ints.length);
    }



}
