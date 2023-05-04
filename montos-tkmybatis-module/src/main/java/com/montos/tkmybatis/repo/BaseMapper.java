package com.montos.tkmybatis.repo;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author : MentosL
 * @date : 2023/4/27 21:39
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
