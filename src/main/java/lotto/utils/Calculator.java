package lotto.utils;

import lotto.domain.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public static double calculateYield(Long totalPrizeMoney, Money money) {
        Integer amount = money.getAmount();
        BigDecimal yield = BigDecimal.valueOf((double) totalPrizeMoney / amount * 100);
        return yield.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}