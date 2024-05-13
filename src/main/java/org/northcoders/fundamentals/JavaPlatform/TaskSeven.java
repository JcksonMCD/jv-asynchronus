package org.northcoders.fundamentals.JavaPlatform;

import java.util.concurrent.*;
import java.util.function.Function;

public class TaskSeven {


    public TaskSeven() throws ExecutionException, InterruptedException {
        ExecutorService test = Executors.newSingleThreadExecutor();
        for (int i = 0; i<3 ; i++) {
            Future<String> printOut = test.submit(() -> "Hello World!");
            String result = printOut.get();
            System.out.println(result);
            Thread.sleep(2000);
        }
        test.shutdown();
    }
}
