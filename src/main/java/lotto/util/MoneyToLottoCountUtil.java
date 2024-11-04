package lotto.util;

import static lotto.constants.NumberConstants.MONEY_UNIT;

public class MoneyToLottoCountUtil {
    public static int moneyToLottoCount(final int money) {
        return money / MONEY_UNIT;
    }
}
