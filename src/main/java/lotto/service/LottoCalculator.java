package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.WinnerResult;
import lotto.domain.Winners;

public class LottoCalculator {
    public static int sumAmount(WinnerResult winnerResult) {
        int totalAmount = 0;
        for (Winners winner : Winners.values()) {
            totalAmount += winnerResult.getAmount(winner) * winner.convertPrizeMoneyToInt();
        }
        return totalAmount;
    }

    public static double calculateFinalRate(WinnerResult winnerResult, int money) {
        int totalAmount = sumAmount(winnerResult);
        if (totalAmount == 0) {
            return 0;
        }
        double rate = ((double) totalAmount / money) * 100;
        BigDecimal roundedRate = new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP);
        return roundedRate.doubleValue();
    }
}
