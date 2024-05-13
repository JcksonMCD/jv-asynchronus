package org.northcoders.fundamentals.JavaPlatform;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TaskFive {

    public static void main(String[] args) throws InterruptedException {
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
        List<BigInteger> integerList = parseToBigIntList(data);

        System.out.println("Big integer list: " + integerList);

        CompletableFuture.runAsync(() -> {
            String story = "Mary had a little lamb, its fleece was white as snow.";
            String[] words = story.split(" ");

            for (String w : words){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(w);
            }
                });

        CompletableFuture<List<BigInteger>> factorialFuture = CompletableFuture.supplyAsync(() ->
                integerList.stream()
                        .map(TaskFive::calculateFactorial)
                        .toList()
        );

        factorialFuture.thenAccept(result -> {
            System.out.println("Factorials list: " + result);
        });

        Thread.sleep(60000);
    }

    private static List<BigInteger> parseToBigIntList(String data) {
        String[] numbers = data.split(" ");
        List<BigInteger> integerList = new ArrayList<>();
        for (String num : numbers) {
            integerList.add(new BigInteger(num));
        }
        return integerList;
    }

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

}
