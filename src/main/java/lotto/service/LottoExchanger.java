package lotto.service;

import static lotto.util.Constants.AMOUNT_UNIT;

public class LottoExchanger {
    public static int divideByThousand(int money) {
        return money / AMOUNT_UNIT.getIntValue();
    }
}