package lotto.validation;

import lotto.exception.LottoArgumentException;
import lotto.exception.LottoErrorMessage;

public class MoneyValidation {
    private static final int MINIMUM_BUY = 1_000;
    private static final int LOTTO_UNIT = 1_000;

    public static void isValidateAmount(int amount) {
        checkMinimumBuy(amount);

        checkDivLottoUnit(amount);
    }

    private static void checkMinimumBuy(int amount) {
        if (amount < MINIMUM_BUY) {
            throw new LottoArgumentException(LottoErrorMessage.LESS_MIN_AMOUNT_ERROR);
        }
    }

    private static void checkDivLottoUnit(int amount) {
        if (amount % LOTTO_UNIT != 0) {
            throw new LottoArgumentException(LottoErrorMessage.DIV_1_000_AMOUNT_ERROR);
        }
    }
}
