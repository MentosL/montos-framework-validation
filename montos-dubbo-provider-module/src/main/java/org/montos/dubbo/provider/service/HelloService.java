package org.montos.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.montos.dubbo.api.service.IHelloService;

import java.util.concurrent.CompletableFuture;

/**
 * @author Montos
 * @create 2021/5/19 7:12 下午
 */
@Service(timeout = 10_000)
public class HelloService implements IHelloService {
    @Override
    public String helloSync(String name) {
        try {
            Thread.sleep(9_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "provider: helloSync" + name;
    }

    @Override
    public CompletableFuture<String> helloAsync(String name) {
        return CompletableFuture.supplyAsync(() -> "provider: helloAsync" + name);
    }
}
