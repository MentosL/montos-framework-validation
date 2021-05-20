package org.montos.dubbo.api.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author Montos
 * @create 2021/5/19 6:17 下午
 */
public interface IHelloService {

    String helloSync(String name);

    CompletableFuture<String> helloAsync(String name);
}
