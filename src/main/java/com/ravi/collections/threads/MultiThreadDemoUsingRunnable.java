package com.ravi.collections.threads;

class MutiThreadDemoUsingRunnable {
    public static void main(String[] args) {
        int n = 5; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread demo = new Thread(new MultiThreadUsingRunnable());
            demo.start();
        }
    }

    private static class MultiThreadUsingRunnable implements Runnable {
        public void run() {
            try {
                System.out.println("Current thread running is: " + Thread.currentThread().getId());
            } catch (Exception e) {
                System.out.println("Exception encountered");
            }
        }
    }
}
