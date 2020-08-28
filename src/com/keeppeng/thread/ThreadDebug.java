package com.keeppeng.thread;

public class ThreadDebug  extends Thread{
    @Override
    public void run() {
        System.out.println("This is thread running...");
    }

    public static void main(String[] args) {
        ThreadDebug threadDebug = new ThreadDebug();
        //threadDebug.run();
        threadDebug.start();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
