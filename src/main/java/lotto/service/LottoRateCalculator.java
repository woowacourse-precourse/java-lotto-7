package lotto.service;

import java.util.List;
import lotto.dto.MatchingCountResult;

public class LottoRateCalculator {
    public static double calculateReturnOfRate(int purchaseAmount, List<MatchingCountResult> countResults) {
        double profit = 0;
        for (MatchingCountResult matchingCountResult : countResults) {
            int count = matchingCountResult.conditionCount();
            int amount = matchingCountResult.winningCondition().getPrizeAmount();
            profit += count * amount;
        }
        return (profit / purchaseAmount) * 100;
    }

}
