package lotto.domain.calculator;

import static lotto.exception.ErrorMessage.*;

import lotto.dto.result.ProfitResult;
import lotto.exception.CustomIllegalArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitCalculator {

    public static ProfitResult calculateProfit(int totalPurchaseAmount, int totalPrizeAmount) {
        BigDecimal profitRate = calculateProfitRate(totalPurchaseAmount, totalPrizeAmount);
        return new ProfitResult(totalPurchaseAmount, totalPrizeAmount, profitRate);
    }

    private static BigDecimal calculateProfitRate(int totalPurchaseAmount, int totalPrizeAmount) {
        if (totalPurchaseAmount == 0) {
            throw CustomIllegalArgumentException.from(NOT_ZERO_TOTAL_PURCHASE);
        }
        BigDecimal profitRate = BigDecimal.valueOf((double) totalPrizeAmount / totalPurchaseAmount * 100);
        return profitRate.setScale(1, RoundingMode.HALF_UP);
    }
}
