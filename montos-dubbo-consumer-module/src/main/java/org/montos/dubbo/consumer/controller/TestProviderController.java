package org.montos.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.montos.dubbo.api.service.IHelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Montos
 * @create 2021/5/20 9:43 上午
 */
@RestController
public class TestProviderController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Reference(timeout = 11_000)
    private IHelloService iHelloService;


    @RequestMapping("hello1")
    public String testHello1() {
        try {
            Thread.sleep(12_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return iHelloService.helloSync("hello1");
    }


    @RequestMapping("hello2")
    public String testHello2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello2 = iHelloService.helloAsync("hello2");
        // 增加回调
        hello2.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(dateFormat.format(new Date()) + ":Response: " + v);
            }
        });
        // 早于结果输出
        System.out.println(dateFormat.format(new Date()) + "Executed before response return.");
        return hello2.get();
    }
}
