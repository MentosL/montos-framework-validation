package org.montos.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Montos
 * @create 2021/2/23 9:23 上午
 */
@SpringBootApplication
@EnableAsync
public class AsyncSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncSpringBootApplication.class,args);
    }
}
