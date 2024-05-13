package org.northcoders.fundamentals.JavaPlatform;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Print "Hello World!" to the console asynchronously after a delay of two seconds using a CompletableFuture.
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello World!");
        });

        Thread.sleep(5000);

    }
}