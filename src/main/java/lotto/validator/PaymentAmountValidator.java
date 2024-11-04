package lotto.validator;

import lotto.configuration.LottoConfiguration;
import lotto.exception.ExceptionUtils;
import lotto.exception.PurchaseExceptionMessage;

public class PaymentAmountValidator {

    public static void validate(int amount) {
        if (amount < LottoConfiguration.LOTTO_PRICE.getValue()) {
            throw ExceptionUtils.IllegalArgument(PurchaseExceptionMessage.AMOUNT_LESS_THAN_PRICE);
        }
        if (amount % LottoConfiguration.LOTTO_PRICE.getValue() != 0) {
            throw ExceptionUtils.IllegalArgument(PurchaseExceptionMessage.AMOUNT_NOT_MULTIPLE_OF_PRICE);
        }
        if (amount > LottoConfiguration.PURCHASE_LIMIT.getValue()) {
            throw ExceptionUtils.IllegalArgument(PurchaseExceptionMessage.AMOUNT_EXCEEDS_LIMIT);
        }
    }

}
