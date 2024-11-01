package lotto.model;

import static lotto.constants.LottoConfig.AMOUNT_UNIT;

public class LottoExchanger {
    public static int divideByThousand(int money) {
        return money / AMOUNT_UNIT.getValue();
    }
}