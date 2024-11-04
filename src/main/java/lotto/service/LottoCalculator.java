package lotto.service;

import static lotto.utils.Constants.HUNDRED_VALUE;
import static lotto.utils.Constants.ROUND_NUMBER;
import static lotto.utils.Constants.ZERO_VALUE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.WinnerResult;
import lotto.domain.Winners;

public class LottoCalculator {
    public static int sumAmount(WinnerResult winnerResult) {
        int totalAmount = ZERO_VALUE;
        for (Winners winner : Winners.values()) {
            totalAmount += winnerResult.getAmount(winner) * winner.convertPrizeMoneyToInt();
        }
        return totalAmount;
    }

    public static double calculateFinalRate(WinnerResult winnerResult, int money) {
        int totalAmount = sumAmount(winnerResult);
        if (totalAmount == ZERO_VALUE) {
            return 0;
        }
        double rate = ((double) totalAmount / money) * HUNDRED_VALUE;
        BigDecimal roundedRate = new BigDecimal(rate).setScale(ROUND_NUMBER, RoundingMode.HALF_UP);
        return roundedRate.doubleValue();
    }
}
