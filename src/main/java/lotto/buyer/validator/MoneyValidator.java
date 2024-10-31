package lotto.buyer.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class MoneyValidator {
    public static void validate(Long money) {
        limitAmountValidator(money);
        divisibleByThousandValidator(money);
    }
    private static void divisibleByThousandValidator(Long money) {
        if (money % LottoConstant.PURCHASE_AMOUNT.getValue() != 0) ErrorMessage.DIVISIBLE_BY_THOUSAND.throwIllegalArgumentException();
    }
    private static void limitAmountValidator(Long money) {
        if (money > LottoConstant.PURCHASE_LIMIT_AMOUNT.getValue()) ErrorMessage.AMOUNT_LIMIT.throwIllegalArgumentException();
    }
}