package lotto.system.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import lotto.system.message.Message;
import lotto.system.message.MessageType;

public class InputTask implements Runnable {
    private final BlockingQueue<Message> inputMessageQueue;
    private volatile boolean isRunning = false;

    public InputTask(BlockingQueue<Message> messageQueue) {
        this.inputMessageQueue = messageQueue;
    }

    public void start() {
        isRunning = true;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                String input = Console.readLine();
                if (input != null && !input.trim().isEmpty() && isRunning) {
                    inputMessageQueue.put(new Message(MessageType.USER_INPUT, input));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (NoSuchElementException ignored) {

        }
    }

    public void stop() {
        isRunning = false;
        Console.close();
    }
}