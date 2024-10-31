package lotto.lotto.winning.domain;

import lotto.buyer.domain.Money;
import java.text.DecimalFormat;

public class Benefit {
    private static final double PERCENTAGE = 100.0;
    private static final DecimalFormat decimalFormatter = new DecimalFormat("#,##0.0");
    private final Money benefit;

    public Benefit(Money benefit) {
        this.benefit = benefit;
    }

    public String getDecimalFormatByRateOfReturn(Money money) {
        double rateOfReturn = calculateRateOfReturn(money);
        return decimalFormatter.format(rateOfReturn);

    }
    private double calculateRateOfReturn(Money money) {
        return (((double) benefit.getMoney() / money.getMoney()) * PERCENTAGE);

    }

    @Override
    public String toString() {
        return String.valueOf(benefit.getMoney());
    }
}
