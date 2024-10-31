package lotto.util.calculator;

import lotto.domain.enums.LottoRank;

import java.util.EnumMap;

import static lotto.common.Number.ZERO;

public class InvestmentReturnCalculator {

    private static final int PERCENTAGE = 100;
    private static final int LOTTO_AMOUNT = 1000;

    public static double calculate(EnumMap<LottoRank, Integer> rankCountMap, int purchaseCount) {
        double result = ZERO;

        for (LottoRank lottoRank : LottoRank.values()) {
            int lotteryPrize = lottoRank.lotteryPrize();
            int winningCount = rankCountMap.get(lottoRank);

            result += lotteryPrize * winningCount;
        }
        return result / (purchaseCount * LOTTO_AMOUNT) * PERCENTAGE;
    }
}
