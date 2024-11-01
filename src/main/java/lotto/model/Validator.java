package lotto.model;

import static lotto.constant.message.ErrorMessage.*;
import static lotto.constant.core.ValidatorConstant.*;

public class Validator {

    public static void validateLottoPurchaseAmount(Integer lottoAmount) {
        validateMultiple(lottoAmount);
    }

    private static void validateMultiple(Integer number) {
        if ((number % LOTTO_PRICE.getIntegerValue()) != 0) {
            throw new IllegalArgumentException(INVALID_MULTIPLE_AMOUNT.getMessage(LOTTO_PRICE.getIntegerValue()));
        }
    }
}
