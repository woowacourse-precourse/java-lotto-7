package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

import java.math.BigDecimal;
import java.util.Objects;

public class ProfitRate {
    private static final BigDecimal PERCENTAGE_MULTIPLIER = BigDecimal.valueOf(100);
    private static final int SCALE = 3;
    private final BigDecimal rate;

    private ProfitRate(BigDecimal rate) {
        this.rate = rate;
    }

    public static ProfitRate from(int totalProfits, Money originMoney) {
        if (originMoney == null) {
            throw new LottoException(ErrorMessages.ORIGIN_MONEY_NULL);
        }
        if (originMoney.isZero()) {
            return new ProfitRate(BigDecimal.ZERO);
        }
        return new ProfitRate(calculateRate(totalProfits, originMoney));
    }

    private static BigDecimal calculateRate(int totalProfits, Money originMoney) {
        return BigDecimal.valueOf(totalProfits)
                .divide(originMoney.toBigDecimal(), SCALE, BigDecimal.ROUND_HALF_UP)
                .multiply(PERCENTAGE_MULTIPLIER)
                .max(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfitRate that = (ProfitRate) o;
        return Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    public BigDecimal getRate() {
        return rate;
    }
}
