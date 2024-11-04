package lotto.domain;

import lotto.domain.constant.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;

import static lotto.domain.constant.LottoRule.TICKET_PRICE;

public class EarningRateCalculator {

    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int DECIMAL_PRECISION = 1;

    public double calculateEarningRate(int quantity, EnumMap<Ranking, Integer> statistics) {
        Money totalPrize = calculateTotalPrize(statistics);
        Money purchasedAmount = calculatePurchasedAmount(quantity);
        return calculateEarningRate(totalPrize, purchasedAmount);
    }

    private Money calculateTotalPrize(EnumMap<Ranking, Integer> statistics) {
        return statistics.entrySet().stream()
                .map(entry -> Money.from(entry.getKey().getPrize() * entry.getValue()))
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculatePurchasedAmount(int quantity) {
        return Money.from(quantity * TICKET_PRICE.getNumber());
    }

    private double calculateEarningRate(Money totalPrize, Money purchasedAmount) {
        BigDecimal earningRate = totalPrize.divideWithRoundHalfUp(purchasedAmount);

        BigDecimal profitPercentage = earningRate
                .multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER))
                .setScale(DECIMAL_PRECISION, RoundingMode.HALF_UP);

        return profitPercentage.doubleValue();
    }
}
