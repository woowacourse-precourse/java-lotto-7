package lotto;

import java.util.Map;

public class CalculateRateOfReturn {
    private int purchaseAmount;
    private Map<String, Integer> winningLotto;
    private Map<String, Integer> prizes;

    public CalculateRateOfReturn(int purchaseAmount, LottoWinning lottoWinning, LottoPrizeMap lottoPrizeMap) {
        this.purchaseAmount = purchaseAmount;
        this.winningLotto = lottoWinning.getWinningLotto();
        this.prizes = lottoPrizeMap.getPrizes();
    }

    public double calculateRateOfReturn() {
        return calculateNetProfit() / purchaseAmount * 100.0;
    }

    private double calculateNetProfit () {
        double netProfit = 0;
        for (Map.Entry<String, Integer> entry : winningLotto.entrySet()) {
            Integer prize = prizes.get(entry.getKey());
            netProfit += prize * entry.getValue();
        }

        return netProfit;
    }
}
