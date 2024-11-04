package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Profit {
    private static final int DECIMAL_POINT = 1;
    private static final int PERCENTAGE_CONVERSION = 100;
    private final Money money;
    private final LottoResult lottoResult;

    private Profit(Money money, LottoResult lottoResult) {
        this.money = money;
        this.lottoResult = lottoResult;
    }

    public static Profit of(Money money, LottoResult lottoResult) {
        return new Profit(money, lottoResult);
    }

    public String calculateProfit() {
        double profit = (double) calculateTotalPrize() / money.getMoney() * PERCENTAGE_CONVERSION;
        BigDecimal profitPercent = new BigDecimal(profit).setScale(DECIMAL_POINT, RoundingMode.HALF_UP);
        return profitPercent.toString();
    }

    private long calculateTotalPrize() {
        return lottoResult.calculateRankDistribution()
                .entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
