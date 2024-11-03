package model;

import java.util.List;

public class MoneyCalculator {

    private final List<Integer> matchNumberCount;

    private final List<Integer> winningAmount = List.of(
            5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    );

    public MoneyCalculator(List<Integer> matchNumberCount) {
        this.matchNumberCount = matchNumberCount;
    }

    public long getWinningAmount() {
        long sum = 0;
        for (int i = 3; i < matchNumberCount.size(); i++) {
            sum += (long) winningAmount.get(i - 3) * matchNumberCount.get(i);
        }
        return sum;
    }

}
