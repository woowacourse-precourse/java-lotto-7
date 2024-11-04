package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;

public class LottoEvaluator {
    public Map<WinningResult, Integer> evaluateWinningResult(Lottos lottos, WinningNumbers winningNumbers,
                                                             BonusNumber bonusNumber) {
        Map<WinningResult, Integer> winningResults = new EnumMap<>(WinningResult.class);
        List<LottoResult> results = lottos.getTotalMatchedLottoResult(winningNumbers, bonusNumber);

        for (LottoResult lottoResult : results) {
            int count = lottoResult.getMatchedNumberCount();
            boolean hasBonusNumber = lottoResult.hasBonusNumber();
            WinningResult winningResult = WinningResult.fromMatchedNumberCount(count, hasBonusNumber);
            winningResults.put(winningResult, winningResults.getOrDefault(winningResult, 0) + 1);
        }

        return winningResults;
    }

    public double evaluateProfitRate(Map<WinningResult, Integer> winningResults, int lottoPurchaseAmount) {
        int profit = evaluateProfit(winningResults);
        double profitRate = ((double) profit / lottoPurchaseAmount) * 100;

        return Math.round(profitRate * 100.0) / 100.0;
    }

    private int evaluateProfit(Map<WinningResult, Integer> winningResults) {
        int profit = 0;

        for (Map.Entry<WinningResult, Integer> entry : winningResults.entrySet()) {
            int prize = entry.getKey().getPrize();
            profit += (prize * entry.getValue());
        }

        return profit;
    }
}
