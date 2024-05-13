package org.northcoders.fundamentals.JavaPlatform;

import java.util.concurrent.CompletableFuture;

public class TaskOneAnd2 {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(3000);
        CompletableFuture.runAsync(() -> System.out.print("Hello"));
        Thread.sleep(5000);
        CompletableFuture.runAsync(() -> System.out.print(" World!"));
    }
}
