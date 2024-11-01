package lotto.validator;

import lotto.configuration.LottoConfiguration;
import lotto.exception.LottoValidationException;
import lotto.exception.PurchaseExceptionMessage;

public class PurchaseValidator {

    public static void validate(int amount) {
        if (amount < LottoConfiguration.LOTTO_PRICE.getValue()) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_LESS_THAN_PRICE);
        }
        if (amount % LottoConfiguration.LOTTO_PRICE.getValue() != 0) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_NOT_MULTIPLE_OF_PRICE);
        }
        if (amount > LottoConfiguration.PURCHASE_LIMIT.getValue()) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_EXCEEDS_LIMIT);
        }
    }

}
