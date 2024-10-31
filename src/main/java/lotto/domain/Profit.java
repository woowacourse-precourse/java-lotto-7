package lotto.domain;

import java.math.BigInteger;

public class Profit {

    private final BigInteger profit;

    public Profit(BigInteger profit) {
        this.profit = profit;
    }

    public double calculateReturnRate(BigInteger investment) {
        double rate = (investment.doubleValue() / profit.doubleValue()) * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
