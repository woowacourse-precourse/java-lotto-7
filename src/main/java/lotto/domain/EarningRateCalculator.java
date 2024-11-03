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
        Money totalPrize = statistics.entrySet().stream()
                .map(entry -> Money.from(entry.getKey().getPrize() * entry.getValue()))
                .reduce(Money.ZERO, Money::plus);

        Money purchasedAmount = Money.from(quantity * TICKET_PRICE.getNumber());
        Money earningRate = totalPrize.divideWithRoundHalfUp(purchasedAmount);

        BigDecimal profitPercentage = BigDecimal.valueOf(earningRate.doubleValue()).multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER));
        BigDecimal roundToDecimalPrecision = profitPercentage.setScale(DECIMAL_PRECISION, RoundingMode.HALF_UP);

        return roundToDecimalPrecision.doubleValue();
    }
}
