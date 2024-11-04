package lotto.service;

import java.util.Map;

public class CalculateProfitRate {
    private int purchaseAmount;
    private Map<String, Integer> winningLotto;
    private Map<String, Integer> prizes;

    public CalculateProfitRate(int purchaseAmount, Map<String, Integer> winningLotto, Map<String, Integer> prizes) {
        this.purchaseAmount = purchaseAmount;
        this.winningLotto = winningLotto;
        this.prizes = prizes;
    }

    public double getProfitRate() {
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
