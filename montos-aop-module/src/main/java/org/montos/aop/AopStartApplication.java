package org.montos.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Montos
 * @create 2021/1/26 9:48 下午
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = false,proxyTargetClass = true)
public class AopStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopStartApplication.class,args);
    }
}
