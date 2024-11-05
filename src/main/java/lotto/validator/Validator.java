package lotto.validator;

import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;
import static lotto.constants.NumberConstants.MAX_TICKET_BUY_AMOUNT;
import static lotto.constants.NumberConstants.TICKET_PRICE;
import static lotto.constants.NumberConstants.ZERO;

import lotto.exception.BonusNumberOutOfRangeException;
import lotto.exception.BuyAmountHasChangeException;
import lotto.exception.LottoCountOutOfRangeException;

public class Validator {

    public static void validateBuyAmount(long buyAmount) {
        validateLottoCount(buyAmount);
        validateBuyAmountHasChange(buyAmount);
    }

    private static void validateLottoCount(long buyAmount) {
        if (buyAmount < TICKET_PRICE || buyAmount > MAX_TICKET_BUY_AMOUNT) {
            throw new LottoCountOutOfRangeException();
        }
    }

    private static void validateBuyAmountHasChange(long buyAmount) {
        if (buyAmount % TICKET_PRICE != ZERO) {
            throw new BuyAmountHasChangeException();
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUM || bonusNumber > LOTTO_END_NUM) {
            throw new BonusNumberOutOfRangeException();
        }
    }
}
