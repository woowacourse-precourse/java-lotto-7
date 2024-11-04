package lotto.view.outputview;

import lotto.message.info.InfoMessage;
import lotto.model.service.LottoService;

import java.util.List;
import java.util.Map;

public class ResultView implements Result {

    @Override
    public void responseCntLotto(int cnt) {
        System.out.println("\n" + cnt + InfoMessage.RESPONSE_CNT_LOTTO.getMessage());
    }

    @Override
    public void responseLottoNumberList(List<List<Integer>> lottoNumbersList) {
        for (List<Integer> lottoNumber : lottoNumbersList) {
            System.out.println(lottoNumber);
        }
    }

    public void displayWinningStatistics() {
        System.out.println("\n" + InfoMessage.WRITE_WINNING_STATISTICS.getMessage());
    }

    @Override
    public void winningResult(Map<String, Integer> matchCounts) {
        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            System.out.printf("%s - %d개\n", entry.getKey(), entry.getValue());
        }
    }

    public void totalPrize(double yield) {
        System.out.printf(InfoMessage.RESPONSE_TOTAL_YIELD.getMessage(), yield);
    }
}
