package lotto.model;

import lotto.constants.Ranking;
import lotto.view.OutputMessage;

import java.util.Map;

public class RankingHandler {

    public void printResults(Customer customer) {
        Map<Ranking, Integer> results = customer.getLottoResults();
        for (Ranking ranking : Ranking.values()) {
            if (ranking.isWinning()) {
                int count = results.get(ranking);
                resultOutput(ranking, count);
            }
        }
    }

    private void resultOutput(Ranking ranking, int correctLottoCount) {
        if (ranking == Ranking.FIVE_BONUS) {
            OutputMessage.winningNumberCorrect(ranking.getCount(), ranking.getExpressWinnings(), correctLottoCount);
            return;
        }
        OutputMessage.winningNumberCorrectWithBonus(ranking.getCount(), ranking.getExpressWinnings(), correctLottoCount);
    }


}
