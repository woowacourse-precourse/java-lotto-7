package lotto.service;

import lotto.domain.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitCalculator {

    public static double calculateProfitRate(int[] matchCounts, int purchaseAmount) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += (long) matchCounts[rank.ordinal()] * rank.getPrize();
        }
        BigDecimal profitRate = BigDecimal.valueOf((double) totalPrize / purchaseAmount * 100);
        return profitRate.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}