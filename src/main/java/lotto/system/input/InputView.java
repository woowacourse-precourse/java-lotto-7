package lotto.system.input;

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

    public String showInputMoneyMessage() throws InterruptedException {
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,"구입금액을 입력해 주세요."));
        return inputMessageQueue.take().getContent();
    }

    public String showInputLottoNumberMessage() throws InterruptedException {
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,""));
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,"당첨 번호를 입력해 주세요."));
        return inputMessageQueue.take().getContent();
    }

    public String showInputBonusNumberMessage() throws InterruptedException  {
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,""));
        outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,"보너스 번호를 입력해 주세요."));
        return inputMessageQueue.take().getContent();
    }
}
