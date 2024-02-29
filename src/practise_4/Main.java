package practise_4;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorServiceImp executorService = new ExecutorServiceImp(3);

        Future<Integer> future1 = executorService.submit(() -> 1 + 1);
        System.out.println("Result of Callable task: " + future1.get());

        Future<?> future2 = executorService.submit(() -> System.out.println("Runnable task completed"), "result");
        future2.get(); // Wait for task completion
        System.out.println("Runnable task with result completed");

        Future<?> future3 = executorService.submit(() -> System.out.println("Another Runnable task completed"));
        future3.get(); // Wait for task completion
        System.out.println("Another Runnable task completed");

        Callable<Integer> task1 = () -> 1;
        Callable<Integer> task2 = () -> 2;
        Callable<Integer> task3 = () -> 3;
        executorService.invokeAll(Set.of(task1, task2, task3))
                .forEach(future -> {
                    try {
                        System.out.println("Result of Callable task: " + future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        Integer result = executorService.invokeAny(Set.of(task1, task2, task3));
        System.out.println("Result of any Callable task: " + result);
        executorService.execute(() -> System.out.println("Executing a Runnable task"));
        executorService.shutdown();
    }
}
