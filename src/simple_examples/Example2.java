package simple_examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class HelloFuture implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Hello World");
        return "Hello Future";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex = Executors.newSingleThreadExecutor();
        HelloFuture helloFuture = new HelloFuture();
        Future<String> f = ex.submit(helloFuture);
        System.out.println(f.get());
        ex.shutdown();
    }
}


/***
 * Hello World
 * Hello Future
 */