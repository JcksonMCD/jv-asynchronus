package org.northcoders.fundamentals.JavaPlatform;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Print "Hello World!" to the console asynchronously after a delay of two seconds using a CompletableFuture.
//        CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.print("Hello");
//        });
//        CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.print(" World!");
//        });



        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> "World!");

        CompletableFuture<Void> result = hello.thenCombine(world,(helloOutput , worldOutput) -> {
            try {
                Thread.sleep(3000);
                System.out.println(helloOutput);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(worldOutput);
            return null;
        });

        Thread.sleep(9000);



//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> " World");
//
//        CompletableFuture<String> result = hello.thenCompose(word -> {
//            CompletableFuture<String> combine = world.thenApply(suffix -> word + suffix);
//            return combine;
//        });
//
//        result.thenAccept(System.out::println);
//        world.thenAccept(System.out::println);



    }
}