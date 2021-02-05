package org.montos.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Montos
 * @create 2021/2/3 8:52 下午
 */
@EnableScheduling
@SpringBootApplication
public class ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class,args);
    }
}
