package lotto.utils;

import lotto.domain.Money;

public class Calculator {

    public static double calculateYield(Long totalPrizeMoney, Money money) {
        Integer amount = money.getAmount();

        double yield = (double) totalPrizeMoney / (double) amount * 100;
        return Math.round(yield * 100) / 100.0;
    }
}