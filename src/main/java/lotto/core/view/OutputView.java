package lotto.core.view;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import lotto.core.domain.model.GameResult;
import lotto.core.domain.model.Lotto;
import lotto.core.domain.model.Lottos;
import lotto.core.domain.model.PrizeOption;
import lotto.system.message.Message;
import lotto.system.message.MessageType;


public class OutputView {
    private final BlockingQueue<Message> outputMessageQueue;

    public OutputView(BlockingQueue<Message> outputMessageQueue) {
        this.outputMessageQueue = outputMessageQueue;
    }

    public void showErrorMessage(Exception e) {
        e.printStackTrace();
        if(e.getMessage() != null) sendMessage("[ERROR] : " + e.getMessage());
    }
    public void showInputMoneyMessage() {
        sendMessage("구입금액을 입력해 주세요.");
    }

    public void showLottoAmountMessage(Integer ticketAmount) {
        sendMessage(ticketAmount + "개를 구매했습니다.");
    }

    public void showUserLottoMessage(Lottos userLottos) {
        StringBuilder sb  = new StringBuilder();
        for(Lotto lotto : userLottos.getLottosForMessage()) {
            List<Integer> result = new ArrayList<>(lotto.getNumbersForMessage());
            result.sort((a,b)->a-b);
            sb.append(result).append("\n");
        }
        sendMessage(sb);
    }

    public void showInputLottoNumberMessage() {
        sendMessage("당첨 번호를 입력해 주세요.");
    }

    public void showInputLottoBonusNumberMessage() {
        sendMessage("보너스 번호를 입력해 주세요.");
    }

    public void showResultHeadMessage() {
        sendMessage("당첨 통계");
        sendMessage("---");
    }

    public void showBallCountResult(GameResult lottosResult) {
        StringBuilder sb = new StringBuilder();
        for (PrizeOption result : PrizeOption.values()) {
            if (!result.equals(PrizeOption.UNDER_THREE)) {
                sb.append(result.getMessage()).append(" - ").append(lottosResult.getResultCounts().getOrDefault(result, 0)).append("개\n");
            }
        }
        sendMessage(sb);
    }

    public void showProfit(GameResult lottosResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ").append(String.format("%.1f", lottosResult.getTotalProfit())).append("%입니다.");
        sendMessage(sb);
    }
    private void sendMessage(Object message) {
        try {
            outputMessageQueue.put(new Message(MessageType.SYSTEM_OUTPUT,message));
        } catch (InterruptedException e) {
            throw new RuntimeException("메시지 전송 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
