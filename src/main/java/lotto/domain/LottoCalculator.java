package lotto.domain;

import lotto.message.ResultMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoCalculator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<ResultMessage, Integer> calculateWinningResults(List<Lotto> lottos) {
        Map<ResultMessage, Integer> winningResults = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchedCount = countWinningNumber(lotto);
            boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber);
            ResultMessage resultMessage = ResultMessage.getMessageByResult(matchedCount, isBonusMatched);

            winningResults.put(resultMessage, winningResults.getOrDefault(resultMessage, 0) + 1);
        }
        return winningResults;
    }

    public double calculateProfitRate(Map<ResultMessage, Integer> winningResults, int price) {
        int totalPrize = winningResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().totalPriceMessage(entry.getValue()))
                .sum();
        return (double) totalPrize / price * 100;
    }

    public int countWinningNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
    }
}
