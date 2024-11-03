package lotto.validator;

import lotto.constants.LottoValue;
import lotto.utils.LottoException;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_PRICE;

public class LottoStoreValidator {

    private LottoStoreValidator() {
    }

    public static void validatePurchaseAmount(final int price) {
        if (price % LottoValue.LOTTO_PRICE.getValue() != 0) {
            throw new LottoException(ERROR_LOTTO_PRICE);
        }

    }
}
