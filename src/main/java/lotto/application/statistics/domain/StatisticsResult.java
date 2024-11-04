package lotto.application.statistics.domain;

import static lotto.application.statistics.constants.Constants.PERCENTAGE;

public class StatisticsResult {
    private final RankCounter rankCounter;

    private StatisticsResult(RankCounter rankCounter) {
        this.rankCounter = rankCounter;
    }

    public static StatisticsResult from(RankCounter rankCounter) {
        return new StatisticsResult(rankCounter);
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = rankCounter.calculateTotalPrize();
        return roundToSecondDecimal(calculateRate(totalPrize, purchaseAmount));
    }

    public long getCount(Rank rank) {
        return rankCounter.getCount(rank);
    }


    private double calculateRate(int totalPrize, int purchaseAmount) {
        return (totalPrize / (double) purchaseAmount) * PERCENTAGE;
    }

    private double roundToSecondDecimal(double value) {
        return Math.round(value * PERCENTAGE) / PERCENTAGE;
    }

}
