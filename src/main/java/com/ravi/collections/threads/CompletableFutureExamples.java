package com.ravi.collections.threads;

import java.util.concurrent.*;

public class CompletableFutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Note: because we have not supplied any Thread pool, by default CompletableFuture will try to execute this task
        // by getting a thread from ForkJoinPool.commonPool
        CompletableFuture<String> getFutureWithOutExecutorPool = CompletableFuture.supplyAsync(() -> getHello());
        System.out.println(getFutureWithOutExecutorPool.get());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> getFutureWithExecutorPool = CompletableFuture.supplyAsync(() -> getHello(), executorService);
        System.out.println(getFutureWithExecutorPool.get());

        // Note that the program doesnot exit itself after executing the second completablefuture.
        // The reason is because we are attaching a ExecutorService to the program, the application keeps on listening
        // for new tasks to be submitted to the executorPool. To shutdown the app after completion, we need to
        // call executorservice's shutdown method.

        // shutdown executor service
        executorService.shutdown();
    }

    private static String getHello() {
        System.out.println("Current Thread: " + Thread.currentThread().getId() + " and Name: " + Thread.currentThread().getName());
        return "Hi Hello";
    }
}
