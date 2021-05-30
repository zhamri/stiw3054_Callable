package simple_examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class HelloCallable implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Hello World");
        return "Hello Callable";
    }

    public static void main(String[] args) {

        ExecutorService ex = Executors.newSingleThreadExecutor();
        HelloCallable helloCallable = new HelloCallable();
        ex.submit(helloCallable);
        ex.shutdown();
    }
}


/***
 * Hello World
 */
