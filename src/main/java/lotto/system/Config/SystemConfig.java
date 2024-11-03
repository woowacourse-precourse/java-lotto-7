package lotto.system.Config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lotto.system.input.InputTask;
import lotto.system.message.Message;
import lotto.system.output.OutputTask;

public class SystemConfig {
    private static volatile SystemConfig instance;
    private final BlockingQueue<Message> inputMessageQueue;
    private final BlockingQueue<Message> outputMessageQueue;
    private final InputTask inputTask;
    private final OutputTask outputTask;
    private final Thread inputThread;
    private final Thread outputThread;
    private final ThreadPoolExecutor threadPool;
    private volatile boolean isSystemRunning = false;


    private SystemConfig() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = coreCount * 2;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        this.threadPool = new ThreadPoolExecutor(coreCount, maxPoolSize, 60, TimeUnit.HOURS, queue);
        this.inputMessageQueue = new LinkedBlockingQueue<>();
        this.outputMessageQueue = new LinkedBlockingQueue<>();
        this.inputTask = new InputTask(inputMessageQueue);
        this.outputTask = new OutputTask(outputMessageQueue);
        this.inputThread = new Thread(inputTask, "InputThread");
        this.outputThread = new Thread(outputTask, "OutputThread");

    }

    public static SystemConfig getInstance() {
        if (instance == null) {
            synchronized (SystemConfig.class) {
                if (instance == null) {
                    instance = new SystemConfig();
                }
            }
        }
        return instance;
    }

    public void startSystem() {
        if (!isSystemRunning) {
            isSystemRunning = true;
            inputTask.start();
            outputTask.start();
            inputThread.start();
            outputThread.start();
        }
    }



    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public void shutdown() {
        threadPool.shutdown();
    }
    public BlockingQueue<Message> getInputMessageQueue() {
        return this.inputMessageQueue;
    }
    public BlockingQueue<Message> getOutputMessageQueue() {
        return this.outputMessageQueue;
    }
    public void stopSystem() {
        inputTask.stop();
        outputTask.stop();
        outputThread.interrupt();
        try {
            inputThread.join(1000);
            outputThread.join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
