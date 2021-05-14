package org.montos.pageHelper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.montos.pageHelper.entity.Test;

import java.util.List;

/**
 * @author Montos
 * @create 2021/5/12 7:08 下午
 */
@Mapper
public interface TestMapper {

    List<Test>  list();

}
