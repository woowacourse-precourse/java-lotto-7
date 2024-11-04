package lotto.model;

import lotto.vo.Payment;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.common.Constants.START_INDEX;

public class Prize {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;
    private static final List<Integer> prizes = List.of(FIRST_PRIZE,
            SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE);
    private final List<Integer> rankCount;
    private final int profit;
    private final double profitRate;

    public Prize(List<Integer> rankCount, Payment payment) {
        int investment = payment.getMoney();

        this.rankCount = rankCount;
        this.profit = calculateProfit(rankCount);
        this.profitRate = calculateProfitRate(investment, profit);
    }

    private int calculateProfit(List<Integer> rankCount) {
        return IntStream.range(START_INDEX, rankCount.size())
                .map(idx -> prizes.get(idx) * rankCount.get(idx))
                .sum();
    }

    private double calculateProfitRate(int investment, int profit) {
        if (investment == 0) {
            return 0;
        }
        return (double) profit / investment * 100;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
