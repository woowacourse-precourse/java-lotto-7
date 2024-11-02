package lotto.system.Config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lotto.system.input.InputTask;
import lotto.system.output.OutputTask;

public class SystemConfig {
    private final ThreadPoolExecutor threadPool;
    private final BlockingQueue<String> messageQueue;
    private final InputTask inputTask;
    private final OutputTask outputTask;
    private final Thread inputThread;
    private final Thread outputThread;

    private SystemConfig() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = coreCount * 2;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        this.threadPool = new ThreadPoolExecutor(coreCount, maxPoolSize,
                60, TimeUnit.SECONDS, queue);
        this.messageQueue = new LinkedBlockingQueue<>();
        this.inputTask = new InputTask(messageQueue);
        this.outputTask = new OutputTask(messageQueue);
        this.inputThread = new Thread(inputTask, "InputThread");
        this.outputThread = new Thread(outputTask, "OutputThread");
    }

    public static SystemConfig getInstance() {
        return new SystemConfig();
    }

    public void startSystem() {
        inputThread.setDaemon(true);
        outputThread.setDaemon(true);
        inputThread.start();
        outputThread.start();
    }


    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public void shutdown() {
        threadPool.shutdown();
    }
}
