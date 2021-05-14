package org.montos.pageHelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Montos
 * @create 2021/1/26 9:48 下午
 */
@SpringBootApplication
@MapperScan("org.montos.pageHelper.dao")
public class JDBCTemplateStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(JDBCTemplateStartApplication.class,args);
    }
}
