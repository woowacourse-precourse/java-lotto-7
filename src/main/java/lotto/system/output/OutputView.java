package lotto.system.output;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import lotto.system.message.Message;
import lotto.system.message.MessageType;

public class OutputView {
    private final BlockingQueue<Message> outputMessageQueue;

    public OutputView(BlockingQueue<Message> messageQueue) {
        this.outputMessageQueue = messageQueue;
    }

    public void showQuantityMessage(int quantity) {
        sendMessage(quantity + "개를 구매했습니다.");
    }

    public void showLotto(List<Integer> lotto) {
        sendMessage(lotto.toString());
    }

    public void showIncomeRate(double rate) {
        sendMessage(String.format("총 수익률은 %.1f%%입니다.", rate));
    }

    public void showResultOfBoard(String condition, int count) {
        sendMessage(condition + " - " + count + "개");
    }

    public void showErrorMessage(String error) {
        sendMessage("[ERROR]" + error);
    }
    private void sendMessage(Object message) {
        try {
            outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,message));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("메시지 전송 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
