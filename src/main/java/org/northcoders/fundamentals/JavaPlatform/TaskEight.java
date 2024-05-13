package org.northcoders.fundamentals.JavaPlatform;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskEight {

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService test = Executors.newSingleThreadExecutor();
        List<Integer> numbers = List.of(5, 6, 7, 8, 9);
        List<BigInteger> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(calculateFactorial(BigInteger.valueOf(number)));
        }
        System.out.println(result);
        test.shutdown();
    }
}
