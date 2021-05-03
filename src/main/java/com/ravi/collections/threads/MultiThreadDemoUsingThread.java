package com.ravi.collections.threads;

class MutiThreadDemoUsingThread {
    public static void main(String[] args) {
        int n = 5; // Number of threads
        for (int i = 0; i < n; i++) {
            MutiThreadUsingThread demo
                    = new MutiThreadUsingThread();
            demo.start();
        }
    }

    private static class MutiThreadUsingThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Current thread running is: " + Thread.currentThread().getId());
            } catch (Exception e) {
                System.out.println("Exception encountered");
            }
        }
    }


    // https://www.callicoder.com/java-8-completablefuture-tutorial/
    // https://www.callicoder.com/java-concurrency-multithreading-basics/
    // http://tutorials.jenkov.com/
}