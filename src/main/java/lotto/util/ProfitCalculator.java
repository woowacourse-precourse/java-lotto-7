package lotto.util;

import lotto.service.Payment;

public class ProfitCalculator {

    public static float calculate(Payment payment, Integer prizeMoney) {
        return (float) prizeMoney / payment.getWalletMoney() * 100;
    }
}
