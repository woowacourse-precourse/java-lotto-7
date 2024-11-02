package lotto.service;

import lotto.util.LottoConstant;

public class LottoEarningService {

    public double calculateEarningRate(int[] countRank) {
        int cost = calculateCost(countRank);
        int profit = calculateProfit(countRank);

        return Math.round(((double) profit / cost) * 1000) / 10.0;
    }

    private int calculateCost(int[] countRank) {
        int cost = 0;
        for (int ticket : countRank) {
            cost += ticket * LottoConstant.A_LOTTO_PRICE;
        }
        return cost;
    }

    private int calculateProfit(int[] countRank) {
        int profit = 0;
        profit += countRank[1] * LottoConstant.PRIZE_1st;
        profit += countRank[2] * LottoConstant.PRIZE_2nd;
        profit += countRank[3] * LottoConstant.PRIZE_3rd;
        profit += countRank[4] * LottoConstant.PRIZE_4th;
        profit += countRank[5] * LottoConstant.PRIZE_5th;
        return profit;
    }
}
