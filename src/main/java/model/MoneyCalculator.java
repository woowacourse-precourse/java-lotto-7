package model;

import constant.LottoPrize;
import java.util.List;

public class MoneyCalculator {

    private final List<Integer> matchNumberCount;

    public MoneyCalculator(List<Integer> matchNumberCount) {
        this.matchNumberCount = matchNumberCount;
    }

    public long getWinningAmount() {
        long sum = 0;
        LottoPrize[] prizes = LottoPrize.values();
        for (int i = 3; i < matchNumberCount.size(); i++) {
            sum += (long) prizes[i - 3].getPrize() * matchNumberCount.get(i);
        }
        return sum;
    }

    public String getProfitMargin(int inputMoney, long winningAmount) {
        double profitMargin = (double) winningAmount / inputMoney * 100;
        return String.format("%.1f%%", profitMargin);
    }
}
