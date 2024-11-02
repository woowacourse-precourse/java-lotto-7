package lotto.system.output;

import java.util.concurrent.BlockingQueue;
import lotto.system.message.Message;
import lotto.system.message.MessageType;

public class OutputTask implements Runnable {
    private final BlockingQueue<Message> outputMessageQueue;
    private volatile boolean isRunning = false;

    public OutputTask(BlockingQueue<Message> messageQueue) {
        this.outputMessageQueue = messageQueue;
    }

    public void start() {
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            Message message = outputMessageQueue.poll();
            if (message != null && message.getType() == MessageType.SYSTEM_OUTPUT) {
                processOutput(message.getContent());
            }
        }
    }

    private void processOutput(String message) {
        System.out.println(message);
    }

    public void stop() {
        isRunning = false;
    }
}
