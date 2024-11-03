package lotto.threaed;

import java.util.concurrent.BlockingQueue;
import lotto.system.message.Message;
import lotto.system.message.MessageType;

public class InputView {
    private final BlockingQueue<Message> inputMessageQueue;
    private final BlockingQueue<Message> outputMessageQueue;
    public InputView(BlockingQueue<Message> inputMessageQueue, BlockingQueue<Message> outputMessageQueue) {
        this.inputMessageQueue = inputMessageQueue;
        this.outputMessageQueue = outputMessageQueue;
    }

    public String showInputMessage() throws InterruptedException {
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,"입력해 주세요."));
        return inputMessageQueue.take().getContent();
    }

}
