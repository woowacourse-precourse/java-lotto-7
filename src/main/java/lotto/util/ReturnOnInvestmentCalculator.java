package lotto.util;

import lotto.constant.LottoGrade;

import java.util.Map;

import static lotto.constant.Amount.INITIAL_VALUE;

public class ReturnOnInvestmentCalculator {

    private static final double ROUNDING_SCALE = 10.0;
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static double totalProceeds = INITIAL_VALUE.getValue();

    public static double calculateReturnOnInvestment(Map<LottoGrade, Integer> lottoGradeMap, int purchaseAmount) {

        calculateTotalProceeds(lottoGradeMap);

        return ((double) Math.round((totalProceeds / purchaseAmount * PERCENTAGE_MULTIPLIER) * ROUNDING_SCALE)) / ROUNDING_SCALE;
    }

    private static void calculateTotalProceeds(Map<LottoGrade, Integer> lottoGradeMap) {
        totalProceeds += lottoGradeMap.get(LottoGrade.THREE_MATCHED) * LottoGrade.THREE_MATCHED.getWinningAmount();
        totalProceeds += lottoGradeMap.get(LottoGrade.FOUR_MATCHED) * LottoGrade.FOUR_MATCHED.getWinningAmount();
        totalProceeds += lottoGradeMap.get(LottoGrade.FIVE_MATCHED) * LottoGrade.FIVE_MATCHED.getWinningAmount();
        totalProceeds += lottoGradeMap.get(LottoGrade.BONUS_MATCHED) * LottoGrade.BONUS_MATCHED.getWinningAmount();
        totalProceeds += lottoGradeMap.get(LottoGrade.ALL_MATCHED) * LottoGrade.ALL_MATCHED.getWinningAmount();
    }
}
