package lotto.system.output;

import java.util.concurrent.BlockingQueue;
import lotto.system.SystemIO;

public class OutputTask implements Runnable {
    private BlockingQueue<String> messageQueue;
    private volatile boolean isRunning = true;

    public OutputTask(BlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                String message = messageQueue.take();
                processOutput(message);
                if ("exit".equalsIgnoreCase(message)) {
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processOutput(Object message) {
        SystemIO.showMessageToConsole(message);
    }

    public void stop() {
        isRunning = false;
    }
}
