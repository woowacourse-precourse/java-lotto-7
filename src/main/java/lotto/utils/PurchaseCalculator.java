package lotto.utils;

import lotto.domain.Money;

public class PurchaseCalculator {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}

