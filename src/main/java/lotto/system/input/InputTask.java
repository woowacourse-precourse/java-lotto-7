package lotto.system.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.Queue;
import lotto.system.message.Message;
import lotto.system.message.MessageType;

public class InputTask implements Runnable {
    private final Queue<Message> inputMessageQueue;
    private volatile boolean isRunning = false;
    private volatile static boolean userInput = false;

    public InputTask(Queue<Message> messageQueue) {
        this.inputMessageQueue = messageQueue;
    }

    public static void userInput() {
        userInput = true;
    }
    public void start() {
        isRunning = true;
        userInput = false;
    }

    @Override
    public void run() {
        try {
            while (isRunning && !Thread.currentThread().isInterrupted()) {
                if(userInput) {
                    String input = Console.readLine();
                    if (input != null && !input.trim().isEmpty() && isRunning) {
                        inputMessageQueue.add(new Message(MessageType.USER_INPUT, input));
                    }
                    userInput = false;
                }
            }
       } catch (NoSuchElementException ignored) {
        }finally {
            isRunning = false;
        }
    }

    public void stop() {
        isRunning = false;
    }
}