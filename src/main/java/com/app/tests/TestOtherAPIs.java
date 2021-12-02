package com.app.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author hans
 */
public class TestOtherAPIs {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();

        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());

        List<Future<Boolean>> futures = service.invokeAll(callables);

        for(Future<Boolean> future:futures){
            System.out.println("operation result: " + future.get());
        }
        System.out.println("service shut down" + service.invokeAny(callables));
        service.shutdown();

        System.out.println(service.awaitTermination(30, TimeUnit.SECONDS));

    }
}
