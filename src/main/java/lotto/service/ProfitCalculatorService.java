package lotto.service;

import java.util.List;
import lotto.model.LottoResult;

public class ProfitCalculatorService {
    private static final int THREE_MATCH_PRIZE_AMOUNT = 5000;
    private static final int FOUR_MATCH_PRIZE_AMOUNT = 50000;
    private static final int FIVE_MATCH_PRIZE_AMOUNT = 1500000;
    private static final int FIVE_AND_BONUS_MATCH_PRIZE_AMOUNT = 30000000;
    private static final int SIX_MATCH_PRIZE_AMOUNT = 2000000000;
    public static double calculateProfit(List<LottoResult> lottoResult, int purchasePrice) {
        int prizeAmount = getTotalPrizeAmount(lottoResult);
        return (double) prizeAmount / purchasePrice * 100;
    }

    private static int getTotalPrizeAmount(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .mapToInt(ProfitCalculatorService::getPrizeAmount)
                .sum();
    }

    private static int getPrizeAmount(LottoResult result) {
        if (result.getMatchCount() == 6) {
            return SIX_MATCH_PRIZE_AMOUNT;
        }
        if (result.getMatchCount() == 5 && result.getHasBonus()) {
            return FIVE_AND_BONUS_MATCH_PRIZE_AMOUNT;
        }
        if (result.getMatchCount() == 5) {
            return FIVE_MATCH_PRIZE_AMOUNT;
        }
        if (result.getMatchCount() == 4) {
            return FOUR_MATCH_PRIZE_AMOUNT;
        }
        if (result.getMatchCount() == 3) {
            return THREE_MATCH_PRIZE_AMOUNT;
        }
        return 0;
    }
}