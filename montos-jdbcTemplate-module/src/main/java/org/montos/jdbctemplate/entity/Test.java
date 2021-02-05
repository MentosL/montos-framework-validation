package org.montos.jdbctemplate.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Montos
 * @create 2021/1/30 10:12 下午
 */
@Data
public class Test implements Serializable {
    private int id;
    private String one;
    private String two;
    private Date createTime;

}
