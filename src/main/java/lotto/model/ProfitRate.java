package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * ProfitRate는 수익률을 나타내는 도메인 클래스입니다.
 */
public class ProfitRate {
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
                .divide(originMoney.toBigDecimal(), 3, java.math.RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
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
