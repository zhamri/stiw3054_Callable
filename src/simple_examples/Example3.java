package simple_examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableFactorialTask implements Callable<Integer> {

    private int num = 0;

    public CallableFactorialTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {
        int result = 1;
        for (int i = 2; i <= num; i++)
            result *= i;
        return result;
    }
}


class CallableFactorial {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        CallableFactorialTask task = new CallableFactorialTask(5);
        Future<Integer> f = service.submit(task);
        Integer val = f.get();
        System.out.println(val);
        service.shutdown();
    }
}


/***
 * 120
 */