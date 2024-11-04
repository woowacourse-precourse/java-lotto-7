package lotto.service;

import lotto.model.WinningLotto;
import lotto.util.Constants;

public class ProfitService {
    public double calculate(int lottoCount) {
        int totalSpent = lottoCount * Constants.LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();

        double profitRate = ((double) totalPrize / totalSpent) * Constants.PERCENTAGE_FACTOR;

        return Math.round(profitRate * Constants.ROUND_FACTOR) / Constants.ROUND_FACTOR;
    }

    private int calculateTotalPrize() {
        int totalPrize = Constants.INITIAL_TOTAL_PRIZE;

        for (WinningLotto winning : WinningLotto.values()) {
            totalPrize += winning.getPrize() * winning.getMatchCount();
        }

        return totalPrize;
    }
}
