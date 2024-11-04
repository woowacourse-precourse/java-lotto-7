package lotto.view.outputview;

import lotto.message.info.InfoMessage;
import lotto.model.service.LottoService;

import java.util.Map;

public class ResultView implements Result {

    public String responseCntLotto() {
        return InfoMessage.RESPONSE_CNT_LOTTO.getMessage();
    }

    public void displayWinningStatistics() {
        System.out.println(InfoMessage.WRITE_WINNING_STATISTICS.getMessage());
    }
}
