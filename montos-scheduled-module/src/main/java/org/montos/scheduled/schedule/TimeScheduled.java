package org.montos.scheduled.schedule;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Montos
 * @create 2021/2/3 8:53 下午
 */
//@Service
public class TimeScheduled {

//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


//    public TimeScheduled(TimeScheduled timeScheduled) {
//        this.timeScheduled = timeScheduled;
//    }
//
//    private final TimeScheduled timeScheduled;


//    @Scheduled(cron = "* 0/1 * * * ?")
//    public void test(){
//        System.out.println(simpleDateFormat.format(new Date()));
//    }

    //    @Async
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return finalI + "：这是result";
                }
            });
            list.add(submit);
        }


        Thread.sleep(1_0000);

        threadPoolExecutor.shutdownNow();
        for (Future<String> future : list) {
            System.out.print(future.get());
        }


    }

}
