package org.montos.scheduled.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Montos
 * @create 2021/2/3 8:53 下午
 */
@Component
public class TimeScheduled {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    @Scheduled(cron = "* 0/1 * * * ?")
    public void test(){
        System.out.println(simpleDateFormat.format(new Date()));
    }

}
