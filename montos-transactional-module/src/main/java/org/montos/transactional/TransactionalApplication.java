package org.montos.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Montos
 * @create 2021/2/5 10:45 上午
 */
@SpringBootApplication
@EnableTransactionManagement
public class TransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class,args);
    }
}
