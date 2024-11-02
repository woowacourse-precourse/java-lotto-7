package lotto.service;

import java.util.List;
import lotto.dto.MatchingCountResult;

public class LottoRateCalculator {
    public static double calculateReturnOfRate(int purchaseAmount, List<MatchingCountResult> countResults) {
        double profit = 0;
        for (MatchingCountResult matchingCountResult : countResults) {
            double prize = matchingCountResult.getWinningCondition().getPrizeAmount();
            profit += matchingCountResult.getConditionCount() * prize;
        }
        double rate = (profit / purchaseAmount) * 100;
        return roundUpToSecondDecimal(rate);
    }

    public static double roundUpToSecondDecimal(double value) {
        return Math.ceil(value * 100) / 100;
    }

}
