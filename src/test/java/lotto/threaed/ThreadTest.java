package lotto.threaed;

import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    public void threadNumberCheck(){
        int parallelismCount = ForkJoinPool.commonPool().getParallelism();
        System.out.println("Number of threads in common pool: " + parallelismCount);
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of av ProcessorsCount " + coreCount);
        // 항상 ProcessorsCount = parallelismCount +1 은 아님
    }
}
