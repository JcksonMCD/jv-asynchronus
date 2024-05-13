package org.northcoders.fundamentals.JavaPlatform;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        //Task 1 & 2
//        Thread.sleep(3000);
//        CompletableFuture.runAsync(() -> System.out.print("Hello"));
//        Thread.sleep(5000);
//        CompletableFuture.runAsync(() -> System.out.print(" World!"));


        //Task 3
        CompletableFuture<String> firstWord = CompletableFuture.supplyAsync(() -> {
            int r = (int) (Math.random()*1000);
            try{
                Thread.sleep(r);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello Takes:" +r;
        });

        CompletableFuture<String> secondWord = CompletableFuture.supplyAsync(() -> {
            int r = (int) (Math.random()*1000);
            try{
                Thread.sleep(r);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "\nWorld! Takes:" + r;
        });

        CompletableFuture<String> combineWord = firstWord.thenCombine(secondWord, (first, second) -> first + second);

        combineWord.thenAccept(System.out::println);

        Thread.sleep(10000);

    }
}