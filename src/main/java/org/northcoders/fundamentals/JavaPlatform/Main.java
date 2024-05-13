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
        int randomForHello = (int)(Math.random()*10000);
        int randomForWorld = (int)(Math.random()*10000);
        try {
            if (randomForHello + randomForWorld > 10000) {
                throw new RuntimeException("Takes longer than 10 second");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        CompletableFuture<String> firstWord = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(randomForHello);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello Takes:" +randomForHello;
        });

        CompletableFuture<String> secondWord = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(randomForWorld);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "\nWorld! Takes:" + randomForWorld;
        });

        CompletableFuture<String> combineWord = firstWord.thenCombine(secondWord, (first, second) -> first + second);

        combineWord.thenAccept(System.out::println);

        Thread.sleep(10000);

    }
}