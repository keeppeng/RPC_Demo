package com.keeppeng.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("1111111111");
        return "string ";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new CallAbleThread());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
