package lotto.model;

import static lotto.constants.Constants.AMOUNT_UNIT;

public class LottoExchanger {
    public static int divideByThousand(int money) {
        return money / AMOUNT_UNIT.getValue();
    }
}