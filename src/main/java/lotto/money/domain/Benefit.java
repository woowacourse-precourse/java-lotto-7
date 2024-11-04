package lotto.money.domain;

import java.text.DecimalFormat;

public class Benefit {
    private static final double PERCENTAGE = 100.0;
    private static final DecimalFormat decimalFormatter = new DecimalFormat("#,##0.0");
    private final Money winningAmount;

    public Benefit(Money winningAmount) {
        this.winningAmount = winningAmount;
    }

    public String getDecimalFormatByRateOfReturn(Money money) {
        double rateOfReturn = calculateRateOfReturn(money);
        return decimalFormatter.format(rateOfReturn);

    }
    private double calculateRateOfReturn(Money purchaseAmount) {
        return (((double) winningAmount.getMoney() / purchaseAmount.getMoney()) * PERCENTAGE);

    }

    @Override
    public String toString() {
        return String.valueOf(winningAmount.getMoney());
    }
}
