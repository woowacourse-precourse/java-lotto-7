package lotto.util;

import static lotto.constants.AppConst.DIVISION_UNIT;

public abstract class AmountDivider {

    public static int divideLottoAmount(int amount) {
        return amount / DIVISION_UNIT;
    }
}
