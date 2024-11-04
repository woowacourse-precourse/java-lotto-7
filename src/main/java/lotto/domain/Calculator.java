package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class Calculator {
    private static final double PERCENT_MULTIPLIER = 100.0;
    private final LottoResultChecker lottoResultChecker;
    private final Money money;
    private double profitRate;

    public Calculator(LottoResultChecker lottoResultChecker, Money money) {
        this.lottoResultChecker = lottoResultChecker;
        this.money = money;
    }

    public double getProfitRate() {
        calculateProfitRate();
        return profitRate;
    }

    private void calculateProfitRate() {

        int paymentAmount = money.getPaymentAmount();
        Map<Rank, Integer> rankCount = lottoResultChecker.getRankCount();

        double totalProfit = 0;
        for (Entry<Rank, Integer> entry : rankCount.entrySet()) {
            int prize = entry.getKey().getPrize();
            Integer count = entry.getValue();
            totalProfit += (prize * count);
        }
        profitRate = (totalProfit / paymentAmount) * PERCENT_MULTIPLIER;
    }
}