package lotto.system.input;

import java.util.concurrent.BlockingQueue;
import lotto.system.SystemIO;

public class InputTask implements Runnable {
    private BlockingQueue<String> messageQueue;
    private volatile boolean isRunning = true;

    public InputTask(BlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                String input = SystemIO.readUserInput();
                messageQueue.put(input);

                if ("exit".equalsIgnoreCase(input)) {
                    isRunning = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;
    }
}