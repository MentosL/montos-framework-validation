package org.montos.nacos;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Montos
 * @create 2021/5/14 10:27 上午
 */
@SpringBootApplication
@NacosPropertySource(dataId = "montos-nacos-module", groupId = "TEST_GROUP", autoRefreshed = true,properties= @NacosProperties(namespace = "montos-nacos-module"))
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class,args);
    }
}
