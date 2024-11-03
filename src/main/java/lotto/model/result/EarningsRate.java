package lotto.model.result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.model.money.Money;

public class EarningsRate {

    private static final int SCALE = 1;
    private static final int MAX_SCALE = 5;
    private static final BigDecimal PERCENT = new BigDecimal("100");
    private static final DecimalFormat df = new DecimalFormat("#,##0.0'%'");

    private final BigDecimal value;

    private EarningsRate(final BigDecimal value) {
        this.value = value;
    }

    public static EarningsRate from(final Money totalPrize, final Money purchaseAmount) {
        BigDecimal total = BigDecimal.valueOf(totalPrize.getValue());
        BigDecimal purchase = BigDecimal.valueOf(purchaseAmount.getValue());
        BigDecimal rate = total.divide(purchase, MAX_SCALE, RoundingMode.HALF_UP)
                .multiply(PERCENT)
                .setScale(SCALE, RoundingMode.HALF_UP);
        return new EarningsRate(rate);
    }

    @Override
    public String toString() {
        float rate = value.floatValue();
        return df.format(rate);
    }
}
