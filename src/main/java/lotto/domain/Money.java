package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.constant.LottoConst;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTicketCount() {
        return money / LottoConst.LOTTO_PRICE;
    }

    public String getRateOfReturn(Map<Rank, Integer> result) {
        BigDecimal income = calculateIncome(result);
        return calculateRateOfReturn(income);
    }

    private static BigDecimal calculateIncome(Map<Rank, Integer> result) {
        BigDecimal income = BigDecimal.ZERO;
        for (Rank rank : result.keySet()) {
            BigDecimal price = BigDecimal.valueOf(rank.getPrice());
            BigDecimal count = BigDecimal.valueOf(result.get(rank));
            income = income.add(price.multiply(count));
        }
        return income;
    }

    private String calculateRateOfReturn(BigDecimal income) {
        BigDecimal rateOfReturn = income
            .divide(BigDecimal.valueOf(money), LottoConst.ROUNDING_SCALE, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(LottoConst.PERCENTAGE));
        return String.format("%.1f", rateOfReturn);
    }
}
