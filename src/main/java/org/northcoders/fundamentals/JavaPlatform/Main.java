package org.northcoders.fundamentals.JavaPlatform;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        //Task 5
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
        List<String> dataList = List.of(data.split(" "));
        List<BigInteger> integerList = new ArrayList<>();
        for (String d : dataList){
            integerList.add(BigInteger.valueOf(Integer.parseInt(d)));
        }

        for (BigInteger element : integerList) {
            CompletableFuture<BigInteger> future = CompletableFuture.supplyAsync(() -> element);

            CompletableFuture<String> thenApply = future
                    .thenApply(Main::calculateFactorial)
                    .thenApplyAsync(value -> "Result after applying thenApply(): " + value);

            CompletableFuture<Void> thenAccept = future.thenAccept(value -> System.out.println("Result after applying thenAccept(): " + value));
        }



        //        //Task 1 & 2
//        Thread.sleep(3000);
//        CompletableFuture.runAsync(() -> System.out.print("Hello"));
//        Thread.sleep(5000);
//        CompletableFuture.runAsync(() -> System.out.print(" World!"));

//        //Task 3
//        int randomForHello = (int)(Math.random()*10000);
//        int randomForWorld = (int)(Math.random()*10000);
//        try {
//            if (randomForHello + randomForWorld > 10000) {
//                throw new RuntimeException("Takes longer than 10 second");
//            }
//        }catch (RuntimeException e){
//            System.out.println(e.getMessage());
//        }
//
//        CompletableFuture<String> firstWord = CompletableFuture.supplyAsync(() -> {
//            try{
//                Thread.sleep(randomForHello);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Hello Takes:" +randomForHello;
//        });
//
//        CompletableFuture<String> secondWord = CompletableFuture.supplyAsync(() -> {
//            try{
//                Thread.sleep(randomForWorld);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "\nWorld! Takes:" + randomForWorld;
//        });
//
//        CompletableFuture<String> combineWord = firstWord.thenCombine(secondWord, (first, second) -> first + second);
//
//        combineWord.thenAccept(System.out::println);
//
//        Thread.sleep(10000);


    }
}