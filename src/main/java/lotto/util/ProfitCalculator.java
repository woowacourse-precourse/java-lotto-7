package lotto.util;

import lotto.service.Payment;

public class ProfitCalculator {

    private static final Long PERCENT = 100L;

    public static double calculate(Payment payment, Long prizeMoney) {
        return (double) prizeMoney / payment.getWalletMoney() * PERCENT;
    }
}
