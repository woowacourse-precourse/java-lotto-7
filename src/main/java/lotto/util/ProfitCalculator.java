package lotto.util;

import lotto.service.Payment;

public class ProfitCalculator {

    private static final Integer PERCENT = 100;

    public static float calculate(Payment payment, Integer prizeMoney) {
        return (float) prizeMoney / payment.getWalletMoney() * PERCENT;
    }
}
