package org.northcoders.fundamentals.JavaPlatform;

import java.util.concurrent.CompletableFuture;

public class TaskThreeAndFour {
    public static void main(String[] args) throws InterruptedException {

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
