package lotto.model.statistic;

import java.math.BigDecimal;

public class EarningRate {

    private final BigDecimal value;

    private EarningRate(final BigDecimal value) {
        this.value = value;
    }

    public static EarningRate from(String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return new EarningRate(bigDecimal);
    }

    // 투자금, 총 수익금
}
