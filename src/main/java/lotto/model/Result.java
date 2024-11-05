package lotto.model;

import lotto.enumMessage.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private final List<Integer> results;
    private String rate;

    public Result() {
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public void put(long matchingCount, boolean hasBonusNumber) {
        if (isRecordableCount(matchingCount)) {
            Rank rank = Rank.valueOf((int) matchingCount, hasBonusNumber);
            int index = rank.ordinal();
            increaseMatchingIndex(index);
        }
    }

    private boolean isRecordableCount(long matchingCount) {
        return matchingCount != 0 && matchingCount != 1 && matchingCount != 2;
    }

    private void increaseMatchingIndex(int matchingIndex) {
        results.set(matchingIndex, results.get(matchingIndex) + 1);
    }

    public void calculateRate(UserLottos userLottos) {
        Double value = (getProfit() / (double) getInvestmentCost(userLottos)) * 100;
        DecimalFormat(value);
    }

    private void DecimalFormat(double value) {
        DecimalFormat df = new DecimalFormat("#,###.0");
        rate = df.format(value);
    }

    private long getInvestmentCost(UserLottos userLottos) {
        return userLottos.getPurchaseAmount();
    }

    private long getProfit() {
        long profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getPrize() * results.get(rank.ordinal());
        }
        return profit;
    }

    public String getRate() {
        return rate;
    }

    public List<Integer> getResult() {
        return results;
    }
}
